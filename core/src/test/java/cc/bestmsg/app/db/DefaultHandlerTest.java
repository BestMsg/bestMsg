package cc.bestmsg.app.db;

import java.sql.Connection;

import cc.bestmsg.core.db.DBHander;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 * Created by  songzip on 2020/6/3.
 */
public class DefaultHandlerTest {

    DBHander hander = new DefaultHandler();
    
    @org.junit.Test
    public void getConnection() {
        Connection conn = hander.getConnection();
        Assert.assertNotNull(hander);
        
        hander.closeConnection(conn);
        
    }

    @org.junit.Test
    public void closeConnection() {
    }
}
