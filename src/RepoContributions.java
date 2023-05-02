import java.io.IOException;
import java.util.List;

import com.google.gson.JsonSyntaxException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RepoContributions {

    public void getDataFromAPI(String url) {
        String apiUrl;

        // Check protocol to adjust substring starting point
        if (url.toLowerCase().startsWith("http://")) {
            apiUrl = String.format("https://api.github.com/repos/%s/stats/contributors", url.substring(18));
        } else {
            apiUrl = String.format("https://api.github.com/repos/%s/stats/contributors", url.substring(19));
        }

        // Create OkHttp client
        OkHttpClient client = new OkHttpClient();

        // Build request with apiUrl
        Request request = new Request.Builder().url(apiUrl).
                header("Accept", "application/vnd.github.v3+json").build();

        // Store an array of repo contributors
        Contributor[] contributors;
        try {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Display desired data to user
            try {
                contributors = gson.fromJson(responseBody, Contributor[].class);
                System.out.println("Contribution data for " + url);
                System.out.println("-------------------------------------------------------------");
                for (Contributor contributor : contributors) {
                    System.out.println("- " + contributor.author.login + ": " + contributor.total + " Total Contributions, " + contributor.total / contributor.weeks.size() + " Commits per Week");
                }
            } catch (JsonSyntaxException e) {
                System.out.println("Error parsing, please make sure this is a public repository. " + e.getMessage());

                //TODO - Fix bug where JSON is not parsed and instead produces the JsonSyntaxException (java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $)
                Driver.driver(); // Current fix is restarting program
            } catch (Exception e) {
                // This should never happen as protocol is verified to be http or https prior to this method call
                System.out.println("Error processing HTTP response.");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print link to JSON received from GitHub API
        System.out.println(apiUrl);
    }

    private class Contributor {
        private Author author;
        private int total;
        private List<Week> weeks;
    }

    private class Week {
        private long w;
    }

    private class Author {
        private String login;
    }

}


