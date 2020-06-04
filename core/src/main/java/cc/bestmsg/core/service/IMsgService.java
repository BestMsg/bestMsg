package cc.bestmsg.core.service;

import java.util.List;
import java.util.Map;

import cc.bestmsg.core.constant.MsgStatus;
import cc.bestmsg.core.model.Message;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface IMsgService {
    
     void send(Message msg);

     Map<String ,List<Message>> getMessage(MsgStatus status, int offset, int pageSize);
     Map<String ,List<Message>> getMessage();
}
