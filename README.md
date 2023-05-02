# GR_Coding_Challenge
Technical Challenge for Junior Software Engineer Position at G-Research.

<h1>Initial Thoughts</h1>
<p>Need to gather data from a public repository on Github to determine productivity of team. How do I determine/measure productivity? Is productivity based on 
commits/contributions, lines of code, difficulty of problem solved, time spent, or a mixture of all? Do I have access to information like the time spent on any 
given commit or number of lines of code added? How could I determine the difficulty level of the problem solved in an individual contribution? I need to collect the data from Github and parse it for use in the report. Will need to research most efficient ways of gathering this data from Gitbub.</P>

<h1>Minimum Viable Product</h1>
<p>In my opinion, a viable MVP would be a program that when run, gathers necessary data from the Github repository and gives a detailed breakdown of a teams 
productivity over the life of the repository. This MVP would contain a break down of data directly from GitHub for the entire team in a readable way for the user.</p>

<h1>List of Tasks to Complete</h1>
<ul>
  <li>MVP</li>
  <ul>
    <li>Create project and make initial commit to Github</li>
    <li>Get valid repo URL from user</li>
    <li>Gather data from Github API</li>
    <li>Parse data for team members productivity</li>
    <li>Create and display report</li>
  </ul>
  <li>Create and display mathematical measurements of productivity (example: lines of code per week or month)</li>
  <li>Other Possilbe Features</li>
  <ul>
    <li>Graphs and charts to visualize data for user</li>
    <li>Export report to txt file for user to distribute</li>
    <li>Allow user to generate multiple reports at a time</li>
    <li></li>
  </ul>
  <li>Build project and verify it runs as intended</li>
  <li>Complete README.md documentation on GitHub</li>
  <li>Add gr-coding-challenge user to repository</li>
  <li>Submit solution to SES-tech-test@gresearch.co.uk</li>
  <li>Email Jay to inform him that my solution has been submitted</li>
</ul>

<h1>User Instructions</h1>

<h1>Next Steps</h1>

<h1>Technical and Design Decisions</h1>
Python was originally the only language mentioned in job description but Jay sent me an updated list of acceptable languages, Java was included in this list.
Java is the language I have the most experience with through my academic career thus I chose to complete this challenge with Java. After doing some research I chose
chose to use OkHttp to make the Get request and to use the open source Gson to convert the JSON string received from GitHub API to a Java object.

<h1>My Approach and Pivots</h1>
<p>I took some time initially to digest the challenge and wrap my head around the problem. Started to think of different possible approaches and how I would like 
to present the data to the user. After doing some research, I found that repository data can be obtained through GitHubs API and the data is received as JSON.</p>

<h1>Final Thoughts</h1>
