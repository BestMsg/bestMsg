package cc.bestmsg.core.registry;

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
import cc.bestmsg.core.service.ProcessMsgService;

/**
 * Created by  songzip on 2020/3/16.
 */
public class BestMsgServletHelper {


    private final static BestMsgServletHelper instance = new BestMsgServletHelper();
    private ProcessMsgService processMsgService = ProcessMsgService.getInstance();

    public static BestMsgServletHelper getInstance() {
        return instance;
    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();

        response.setCharacterEncoding("utf-8");

        if (contextPath == null) { // root context
            contextPath = "";
        }
        String uri = contextPath + servletPath;
        String path = requestURI.substring(contextPath.length() + servletPath.length());

        Map<String, String[]> parameterMap = request.getParameterMap();

        if (path.contains(".json")) {
            String fullUrl = path;
            if (request.getQueryString() != null && request.getQueryString().length() > 0) {
                fullUrl += "?" + request.getQueryString();
            }
            response.getWriter().print(process(fullUrl, parameterMap));
            return;
        }

        return;
    }


    protected String process(String url, Map<String, String[]> parameters) {
        String resp = null;
        resp = processMsgService.service(url, parameters);

        return resp;
    }
 
}
