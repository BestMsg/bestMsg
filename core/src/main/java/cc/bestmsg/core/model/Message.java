package cc.bestmsg.core.model;

import cc.bestmsg.core.constant.MsgStatus;
import cc.bestmsg.core.constant.MsgType;
import lombok.Data;

/**
 * table name: best_messages
 * Created by  songzip on 2020/3/16.
 */
@Data
public class Message {

    /**
     * uuid
     */
    String id;
    
    MsgType type;
    /**
     * user id who send the message out
     */
    String fromUserId;
    
    String nickName;

    String toUserId;
    /**
     * message body
     */
    String content;

    /**
     * send out time unix ms
     */
    long time;

    /**
     * 1: read
     * 0: unread
     */
    MsgStatus status;
    
}
