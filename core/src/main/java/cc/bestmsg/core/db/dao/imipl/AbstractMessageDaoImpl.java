package cc.bestmsg.core.db.dao.imipl;

import java.util.List;

import cc.bestmsg.core.db.dao.MessageDao;
import cc.bestmsg.core.model.Message;

/**
 * Created by  songzip on 2020/3/16.
 */
public abstract class AbstractMessageDaoImpl implements MessageDao {
    public void save(Message msg) {

    }

    public void markRead(Message msg) {
        markRead(msg.getId());
    }

    public void delete(Message msg) {
        delete(msg.getId());
    }

    public void markRead(String... ids) {

    }

    public void delete(String... ids) {

    }

    public List<Message> getMessage(int status, int offset, int pageSize) {
        return null;
    }
}
