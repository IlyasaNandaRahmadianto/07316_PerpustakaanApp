package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil_07316 {
    public static Statement stmt = null;
    public static ResultSet rs;
    public static Connection getconnection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url    = "jdbc:mysql://localhost:3306/db_perpus";
        String user   = "root";
        String pass   = "";
        try{  
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            System.out.println("Berhasil Koneksi Database");
        }catch(Exception e){
            System.out.println("Gagal Koneksi Database");
            e.printStackTrace();   
        }return conn;
    }}
