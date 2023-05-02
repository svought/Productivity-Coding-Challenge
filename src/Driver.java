import java.net.MalformedURLException;
import java.net.*;
import java.util.Scanner;

public class Driver {

    public static boolean isValidURL(String url) {
        try {
            // Attempt to create a URI with given url
            new URL(url).toURI();
            return url.toLowerCase().startsWith("http://github.com/") || url.toLowerCase().startsWith("https://github.com/");
        } catch (MalformedURLException e) {
            // Handle string not parsed to URL correctly
            System.out.println("Invalid URL");
            return false;
        } catch (URISyntaxException e) {
            // Handle illegal characters in URL
            System.out.println("Illegal characters in URL");
            return false;
        }
    }
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {

        // Get repo URL from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter GitHub repository URL (example: https://github.com/svought/GR_Coding_Challenge) : ");
        String url = scanner.nextLine();

        // Ensure valid url is given by user
        while (!isValidURL(url)) {
            System.out.print("Please enter a valid url (example: https://github.com/svought/GR_Coding_Challenge) : ");
            url = scanner.nextLine();
        }

        // Close scanner
        scanner.close();

        RepoContributions repoContributions = new RepoContributions();

        System.out.println("Valid URL accepted: " + url);
        repoContributions.getDataFromAPI(url);
    }
}
