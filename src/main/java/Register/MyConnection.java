package Register;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

        public Connection mySqlconnetion(){
            Connection connect = null;
            try{

                //Class.forName("com.mysql.jdbc.Driver");

                String url ="jdbc:mysql://localhost:3306/registrationdetails?useSSL=false";
                String username = "root";
                String password = "root";
                connect = DriverManager.getConnection(url, username, password);
                //System.out.println("Connection Established successfully");

            }catch (Exception e){
                e.printStackTrace();
                System.err.println(e.getStackTrace());

            }
            return connect;
        }
    }

