package cc.bestmsg.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cc.bestmsg.core.MsgCenter;
import cc.bestmsg.core.db.DBHander;
import cc.bestmsg.core.model.BestUser;
import cc.bestmsg.core.service.IUserService;

/**
 * Created by  songzip on 2020/6/3.
 */
public class UserService implements IUserService {

    /**
     * 反射获取 当前用户
     * @return
     */
    @Override
    public String getCurrentUserId() {
        return "joey";
    }

    @Override
    public String getCurrentUserNickName() {
        return  getCurrentUserId();
    }

    @Override
    public BestUser getCurrentUser() {
        return new BestUser(getCurrentUserId(), getCurrentUserNickName());
    }

    @Override
    public List<BestUser> getUserList() {
        if (userList == null || userList.isEmpty()) {

            userList = new ArrayList<>();

            DBHander handler = MsgCenter.getDbHandler();
            Connection conn = handler.getConnection();

            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = conn.prepareStatement(USER_LIST_SQL);
                rs = ps.executeQuery();

                while (rs.next()) {
                    userList.add(new BestUser(rs.getString(1), rs.getString(2)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return userList;
    }


    List<BestUser> userList;

    static String USER_LIST_SQL = "select username , full_name from knta_users ";

}
