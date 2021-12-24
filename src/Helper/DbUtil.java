package Helper;

import java.sql.*;
public class DbUtil {
    public static Connection getconnection(){
        Connection conn = null;
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String url    = "jdbc:mysql://localhost:3306/db_perpus";
        String user   = "root";
        String pass   = "";
        
        try{  
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            e.printStackTrace();   
        }return conn;
    }
}