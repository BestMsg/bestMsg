package cc.bestmsg.core.msg;

import java.util.List;

import cc.bestmsg.core.constant.MsgStatus;
import cc.bestmsg.core.model.Message;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface MsgService {
    
     void send(Message msg);
     
     List<Message> getMessage(MsgStatus status, int offset, int pageSize);
}
