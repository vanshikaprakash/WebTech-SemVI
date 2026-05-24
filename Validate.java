import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class validate extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    	boolean st =false;
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        
        
        try {
        
            // loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/sample","root","root");

           PreparedStatement ps = con.prepareStatement("select * from student where uname=? and pass=?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
if (st)
{

     String title = "Logged in Successfully";
	

      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>User Name</b>: "
                  + rs.getString("sname") + "\n" +
                  "  <li><b>Address</b>: "
                  + rs.getString("saddress") + "\n" +
		  "  <li><b>Country</b>: "
                  + rs.getString("scountry") + "\n" +
		  "  <li><b>Pincode</b>: "
                  + rs.getString("spincode") + "\n" +
		  "  <li><b>Email Id:</b>: "
                  + rs.getString("semail") + "\n" +
		  "  <li><b>Gender</b>: "
                  + rs.getString("sgender") + "\n" +
		  "  <li><b>Language</b>: "
                  + rs.getString("slanguage") + "\n" +
		  "  <li><b>Description</b>: "
                  + rs.getString("sdescription") + "\n" +
               "</ul>\n" +
            "</body>\n"+
         "</html>"
      );




  }
else
{
out.println("Username or Password incorrect");
}      
        }
        catch(Exception se) {
            se.printStackTrace();

        }
    
    }
}