package cc.bestmsg.core;

import cc.bestmsg.core.db.DBHander;
import cc.bestmsg.core.msg.MsgService;
import cc.bestmsg.core.user.BestUserService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by  songzip on 2020/3/16.
 */

@Slf4j
@Getter
@Setter
public class MsgCenter {

    private static BestUserService user;
    private static MsgService service;
    private static DBHander dbHandler;


    public static DBHander getDbHandler() {
        return dbHandler;
    }

    public static void setDbHandler(DBHander dbHandler) {
        MsgCenter.dbHandler = dbHandler;
    }
    
    public static MsgService getService(){
        return service;
    }

    public static BestUserService getUser() {
        return user;
    }

    public static void setUser(BestUserService user) {
        MsgCenter.user = user;
    }

    public static void setService(MsgService service) {
        MsgCenter.service = service;
    }
 

    /**
     * check if all interface are registered.
     */
    public void validate(){
        
    }
    
}
