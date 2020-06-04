package cc.bestmsg.core;

import cc.bestmsg.core.db.DBHander;
import cc.bestmsg.core.service.IUserService;
import cc.bestmsg.core.service.IMsgService;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by  songzip on 2020/3/16.
 */

//@Slf4j
@Getter
@Setter
public class MsgCenter {

    private static IUserService userService;
    private static IMsgService msgService ;
    private static DBHander dbHandler;


    public static DBHander getDbHandler() {
        return dbHandler;
    }

    public static void setDbHandler(DBHander dbHandler) {
        MsgCenter.dbHandler = dbHandler;
    }
    
    public static IMsgService getMsgService(){
        return msgService;
    }

    public static IUserService getUserService() {
        return userService;
    }

    public static void setUserService(IUserService userService) {
        MsgCenter.userService = userService;
    }

    public static void setMsgService(IMsgService msgService) {
        MsgCenter.msgService = msgService;
    }
 

    /**
     * check if all interface are registered.
     */
    public void validate(){
        
    }
    
}
