package cc.bestmsg.app;

import cc.bestmsg.app.db.DefaultHandler;
import cc.bestmsg.core.MsgCenter;

/**
 * Created by  songzip on 2020/6/3.
 */
public class App {

    public static void main(String[] args) {

        MsgCenter.setDbHandler(new DefaultHandler());
        
        
    }
}
