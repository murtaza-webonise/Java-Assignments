This Assignment contains 2 jsp pages 1 html file 4 java files and 1 xml file
1)index.html:- Here I created a form which takes id and password and submit it to the LoginServlet.java.
2)AuthenticationFilter:-It implements filter interface and receives request from index.html then checks the session and after authentication redirects it to the LoginServlet.java.
3)RequestLoggingFilter.java:-it logs the cookie information and about various parameters coming fom client.
4) LoginServlet.java:-It checks the login id and password then set the session and cookie.
5)LoginSuccess.jsp:-it prints the user name and its session info.
6)CheckoutSuccess.jsp:it prompts the user to check out.
7)LogoutServlet.java:it invalidates the session and logged out the user.
8)AppExceptionHandler.java.It handles the various internal server error and bad requests and represents it to the user in customised way
