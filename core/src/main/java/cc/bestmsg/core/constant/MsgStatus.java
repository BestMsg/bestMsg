package cc.bestmsg.core.constant;

/**
 * Created by  songzip on 2020/3/16.
 */
public enum MsgStatus {
    
    UNREAD(0),READ(1), ALL(-1);

    private final int code;
    MsgStatus(int code) {
        this.code = code;
    }
    
    public int getCode(){
        return this.code;
    }
     
}
