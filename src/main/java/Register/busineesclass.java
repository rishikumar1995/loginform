package Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class busineesclass {

    public List<Map<String,String>> exporttoexcel() throws SQLException {
        Connection con=new MyConnection().mySqlconnetion();

        PreparedStatement ps=con.prepareStatement("select * from signup");
        ResultSet rs=ps.executeQuery();

        List<Map<String,String>> list=new LinkedList<>();


        while (rs.next()){
            String name=rs.getString("user_name");
            String email=rs.getString("user_email");
            String mobno=rs.getString("mobno");

            Map<String,String> map=new LinkedHashMap<>();
            map.put("name",name);
            map.put("email",email);
            map.put("mobno",mobno);

            list.add(map);
        }
    return list;
    }

}
