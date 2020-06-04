package cc.bestmsg.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import cc.bestmsg.app.db.DefaultHandler;
import cc.bestmsg.app.service.MsgService;
import cc.bestmsg.app.service.UserService;
import cc.bestmsg.core.MsgCenter;
import cc.bestmsg.core.db.dao.imipl.MessageDaoImpl4Ora;
import cc.bestmsg.core.registry.BestMsgServletHelper;
import cc.bestmsg.core.service.ProcessMsgService;

/**
 * you should implement it in you app.
 * Created by  songzip on 2020/3/16.
 */
public class BestMsgServlet extends HttpServlet {

    private BestMsgServletHelper msgServletHelper = BestMsgServletHelper.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        MsgCenter.setDbHandler(new DefaultHandler());
        MsgCenter.setUserService(new UserService());
        MsgCenter.setMsgService(new MsgService(new MessageDaoImpl4Ora(MsgCenter.getDbHandler())));
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        msgServletHelper.service(request, response);
    }
}
