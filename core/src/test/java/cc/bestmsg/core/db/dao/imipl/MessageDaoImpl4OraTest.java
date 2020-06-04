package cc.bestmsg.core.db.dao.imipl;

import java.util.List;
import java.util.Map;

import cc.bestmsg.app.db.DefaultHandler;
import cc.bestmsg.core.db.dao.MessageDao;
import cc.bestmsg.core.model.Message;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by  songzip on 2020/6/3.
 */
public class MessageDaoImpl4OraTest {

    MessageDao md = new MessageDaoImpl4Ora (new DefaultHandler());
    
    @Test
    public void save() {
        Message m = new Message();
        m.setFromUserId("joey");
        m.setNickName("Michael");
        m.setContent("How are you");
        m.setToUserId("mike");
        md.send(m);
    }

    @Test
    public void getMessage() {
        Map<String ,List<Message>> messages = md.getMessage("joey", 0, 0, 10);
        
        Assert.assertTrue(messages.size() > 0 );
        
        messages.keySet().stream().forEach(System.out::println);
        
    }
}
