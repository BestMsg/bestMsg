package cc.bestmsg.app.service;

import java.util.List;

import cc.bestmsg.app.db.DefaultHandler;
import cc.bestmsg.core.MsgCenter;
import cc.bestmsg.core.model.BestUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by  songzip on 2020/6/3.
 */
public class UserServiceTest {

    @Before
    public void setUp() throws Exception {
        MsgCenter.setDbHandler(new DefaultHandler());
        MsgCenter.setUserService(new UserService());
    }

    @Test
    public void getCurrentUserId() {
    }

    @Test
    public void getCurrentUserNickName() {
    }

    @Test
    public void getCurrentUser() {
    }

    @Test
    public void getUserList() {
        List<BestUser> users = MsgCenter.getUserService().getUserList();
        Assert.assertNotNull(users);
        Assert.assertTrue( users.size() > 0);
           
    }
}
