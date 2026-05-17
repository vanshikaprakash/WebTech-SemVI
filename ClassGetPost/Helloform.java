import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Helloform extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String title = "Using GET Method to Read Form Data";

        out.println("<html>");
        out.println("<head><title>" + title + "</title></head>");

        out.println("<body bgcolor='#f0f0f0'>");
        out.println("<h1 align='center'>" + title + "</h1>");

        out.println("<ul>");
        out.println("<li><b>First Name</b>: "
                + request.getParameter("first_name"));
        out.println("<li><b>Last Name</b>: "
                + request.getParameter("last_name"));
        out.println("</ul>");

        out.println("</body></html>");
    }
}