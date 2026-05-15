// Import required java libraries

Import java.io.*;

Import javax.servlet.";

Import javax.servlet.http.*;

// Extend littpServlet class

public class Helloform extends HttpServlet (

public void doGet(HttpServletRequest request, IittpServletResponse response) throws ServletException, IOException (

// Set response content type 

response.setContentType("text/html");

PrintWriter out response.getWriter();

String title "Using GET Method to Read Form Data";

String docType

"<Idoctype html public *-//w3c//dtd html 4.0 "transitional//en\">\n")

out.print 

In(docType + <html>\n" +

"<head><title>" + title + "</title></head>\n" +

"<body bgcolor = \"#f0f0f0\">\n" +

"<h1 align = \"center\">" + title + "</h1>\n" +

"<ul>\n" +

"<li><b>First Name</b>:"

+ request.getParameter("first_name") + "\n" +

"<li><b>Last Name</b>:"

+ request.getParameter("last_name") + "\n" +

"</ul>\n" +

"</body>" +

"</html>"

);