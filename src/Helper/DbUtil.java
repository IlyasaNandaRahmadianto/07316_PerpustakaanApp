package Helper;

import java.sql.*;
public class DbUtil {
   public static Connection getConnection (){
    Connection conn = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/db_perpustakaanapp";
    String user = "root";
    String pass = "";
     
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");
        }
        catch(Exception e){
             System.out.println("Disconnected");
             e.printStackTrace();
        }
        return conn;
    }  
}
