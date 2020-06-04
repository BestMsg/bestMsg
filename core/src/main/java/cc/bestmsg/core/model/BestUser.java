package cc.bestmsg.core.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * user model in bestMsg
 * Created by  songzip on 2020/3/16.
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class BestUser {
    
    String userId;
    String nickName;
    
}
