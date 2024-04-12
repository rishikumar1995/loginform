package Register;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/Registerform")
public class signup extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
       String name=req.getParameter("user_name");
       String email=req.getParameter("user_email");
       String mobno=req.getParameter("user_mobno");
       String password=req.getParameter("user_password");

       try{

           Connection con = new MyConnection().mySqlconnetion();

           PreparedStatement ps=con.prepareStatement("INSERT INTO signup values (?,?,?,?)");
           ps.setString(1,name);
           ps.setString(2,email);
           ps.setString(3,mobno);
           ps.setString(4,password);

           int count=ps.executeUpdate();

           if (count>0){
               resp.setContentType("text/html");
               out.print("<h3 style='color:yellow' align='center' padding-top=5px>Register Successfully</h3>");
               RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
               rd.include(req,resp);
           }else{
               resp.setContentType("text/html");
               out.print("<h3 style='color:red'>Failed to do registration</h3>");
               RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
               rd.include(req,resp);
           }


       }
       catch (SQLException e) {
           System.out.println("SQL Exception"+e.getMessage());
       }
    }

}
