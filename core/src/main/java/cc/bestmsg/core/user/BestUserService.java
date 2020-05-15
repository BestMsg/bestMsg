package cc.bestmsg.core.user;

import cc.bestmsg.core.model.BestUser;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface BestUserService {
    
    String getCurrentUserId();
    String getCurrentUserNickName();
    
    BestUser getCurrentUser();
    
}
