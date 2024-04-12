package Register;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@WebServlet("/loginform")
public class loginformservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String email=req.getParameter("get_email");
        String password=req.getParameter("get_password");

        try{
            Connection con=new MyConnection().mySqlconnetion();

            PreparedStatement ps=con.prepareStatement("select * from signup where user_email=? and user_password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();



            if (rs.next())
            {
                String mobno=rs.getString("mobno");
                String user_email=rs.getString("user_email");
                String user_name=rs.getString("user_name");

                req.setAttribute("UserMobNo",mobno);
                req.setAttribute("UserName",user_name);
                req.setAttribute("UserEmail",user_email);

              if (email==null || password==null){
                  resp.sendRedirect("index.jsp");
              }else{
                  HttpSession session=req.getSession();
                  session.setAttribute("UserMobNo",mobno);
                  session.setAttribute("UserName",user_name);
                  session.setAttribute("UserEmail",user_email);
                  resp.sendRedirect("/loginform.jsp");
              }
            }else{
                resp.sendRedirect("/index.jsp");
            }

        }catch (Exception e){
            System.out.println("Email and Password Invalid"+e.getMessage());
        }
    }
}
