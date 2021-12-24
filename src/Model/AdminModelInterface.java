package Model;

import Helper.DbUtil;
import java.sql.Connection;

public interface AdminModelInterface {
    Connection conn = DbUtil.getconnection();
    
    boolean login(String nama, String password);
}
