package cc.bestmsg.app.service;

import java.util.List;
import java.util.Map;

import cc.bestmsg.core.MsgCenter;
import cc.bestmsg.core.constant.MsgStatus;
import cc.bestmsg.core.db.dao.MessageDao;
import cc.bestmsg.core.model.Message;
import cc.bestmsg.core.service.IMsgService;

/**
 * Created by  songzip on 2020/6/3.
 */
public class MsgService implements IMsgService {

    private final MessageDao dao;

    public MsgService(MessageDao dao) {
        this.dao = dao;
    }

    @Override
    public void send(Message msg) {
        this.dao.send(msg);
    }

    @Override
    public Map<String ,List<Message>> getMessage(MsgStatus status, int offset, int pageSize) {
        return this.dao.getMessage(MsgCenter.getUserService().getCurrentUserId(), status.getCode(), offset, pageSize);
    }

    @Override
    public Map<String ,List<Message>> getMessage() {
        return this.getMessage(MsgStatus.ALL, 0, 100);
    }
}
