package cc.bestmsg.core.db.dao;

import java.util.List;

import cc.bestmsg.core.model.Message;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface MessageDao {
    
    void save(Message msg);
    void markRead(Message msg);
    void delete(Message msg);

    void markRead(String ... ids );
    void delete(String ... ids);
    
    List<Message> getMessage(int status, int offset, int pageSize);
}
