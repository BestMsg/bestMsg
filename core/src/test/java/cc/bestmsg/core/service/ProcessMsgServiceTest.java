package cc.bestmsg.core.service;

import java.util.HashMap;
import java.util.Map;

import cc.bestmsg.app.db.DefaultHandler;
import cc.bestmsg.app.service.MsgService;
import cc.bestmsg.app.service.UserService;
import cc.bestmsg.core.MsgCenter;
import cc.bestmsg.core.constant.Parameter;
import cc.bestmsg.core.db.dao.imipl.MessageDaoImpl4Ora;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by  songzip on 2020/6/3.
 */
public class ProcessMsgServiceTest {

    @Before
    public void setUp() throws Exception {
        MsgCenter.setDbHandler(new DefaultHandler());
        MsgCenter.setUserService(new UserService());
        MsgCenter.setMsgService(new MsgService(new MessageDaoImpl4Ora(MsgCenter.getDbHandler())));
    }

    @Test
    public void service() {
        String result = ProcessMsgService.getInstance().service("/messages.json", new HashMap<>());
        System.out.println(result);
        Assert.assertNotNull(result);


    }


    @Test
    public void service1() {

        Map<String, String[]> parameters = new HashMap<>();
        parameters.put(Parameter.MESSAGE, new String[]{"Hello world."});
        parameters.put(Parameter.TO, new String[]{"tom"});


        String result = ProcessMsgService.getInstance().service("/send.json", parameters);
        System.out.println(result);
        Assert.assertNotNull(result);


    }
}
