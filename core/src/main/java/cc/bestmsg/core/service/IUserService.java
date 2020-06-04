package cc.bestmsg.core.service;

import java.util.List;

import cc.bestmsg.core.model.BestUser;

/**
 * Created by  songzip on 2020/3/16.
 */
public interface IUserService {
    
    String getCurrentUserId();
    String getCurrentUserNickName();
    
    BestUser getCurrentUser();
    
    List<BestUser> getUserList();
    
}
