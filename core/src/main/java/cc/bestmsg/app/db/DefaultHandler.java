package cc.bestmsg.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cc.bestmsg.core.db.DBHander;

/**
 * Created by  songzip on 2020/6/3.
 */
public class DefaultHandler implements DBHander {
    
      static String JDBC_URL = "jdbc:oracle:thin:@192.168.57.3:1521:orcl";
    
    static String username = "PPM_952_SZP";
    static String password = "PPM_952_SZP";
    
    
    static {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void closeConnection(Connection conn) {
    
        try{
            conn.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
