package cc.bestmsg.core.model;

import cc.bestmsg.core.constant.MsgStatus;
import cc.bestmsg.core.constant.MsgType;
import lombok.Data;

/**
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
    
    String fromUserNickName;

    String toUserId;
    /**
     * message body
     */
    String content;

    /**
     * send out time unix ms
     */
    int time;

    /**
     * 
     */
    MsgStatus status;
    
}
