package cc.bestmsg.core.db;

import java.sql.Connection;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface DBHander {

    public Connection getConnection();
    public void closeConnection(Connection conn);
    
//    int executeUpdate(String sql);
//    int executeUpdate(String sql, Object[] parameters);

}
