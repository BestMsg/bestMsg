package cc.bestmsg.core.db.dao;

import java.util.List;
import java.util.Map;

import cc.bestmsg.core.model.Message;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface MessageDao {

    void send(Message msg);

    void markRead(Message msg);

    void delete(Message msg);

    void markRead(String... ids);

    void delete(String... ids);

    Map<String ,List<Message>>  getMessage(String currentUserId, int status, int offset, int pageSize);

    Map<String ,List<Message>> getMessage(String currentUserId, long timestamp , int status, int offset, int pageSize) ;
}
