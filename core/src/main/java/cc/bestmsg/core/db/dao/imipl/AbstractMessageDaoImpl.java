package cc.bestmsg.core.db.dao.imipl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cc.bestmsg.core.constant.MsgStatus;
import cc.bestmsg.core.constant.MsgType;
import cc.bestmsg.core.db.DBHander;
import cc.bestmsg.core.db.dao.MessageDao;
import cc.bestmsg.core.model.Message;

/**
 * Created by  songzip on 2020/3/16.
 */
public abstract class AbstractMessageDaoImpl implements MessageDao {

    protected final DBHander dbHander;

    public AbstractMessageDaoImpl(DBHander dbHander) {
        this.dbHander = dbHander;
    }

    /**
     * no update , always insert.
     *
     * @param msg
     */
    public void send(Message msg) {
        String insertSql = "insert into best_messages(id, type, from_user_id, nick_name,  content, to_user_id,time )" +
                "values (?,?,?,?,?,?,?)";


        try (Connection conn = this.dbHander.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSql)) {

            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, MsgType.CHAT.name());
            ps.setString(3, msg.getFromUserId());
            ps.setString(4, msg.getNickName());
            ps.setString(5, msg.getContent());
            ps.setString(6, msg.getToUserId());
            ps.setLong(7, System.currentTimeMillis());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void markRead(Message msg) {
        markRead(msg.getId());
    }

    public void delete(Message msg) {
        delete(msg.getId());
    }

    public void markRead(String... ids) {

    }

    public void delete(String... ids) {

    }

    public Map<String, List<Message>> getMessage(String currentUserId, int status, int offset, int pageSize) {
        return getMessage(currentUserId, -1, status, offset, pageSize);
    }

    public Map<String, List<Message>> getMessage(String currentUserId, long timestamp, int status, int offset, int pageSize) {

        Map<String, List<Message>> chatList = new HashMap<>();

        List<Object> parameters = new ArrayList<>();

        StringBuffer sSql = new StringBuffer("select id, type, from_user_id, nick_name, content, to_user_id, time, status from best_messages " +
                " where (to_user_id = ? or from_user_id = ? )and time > ?");
        parameters.add(currentUserId);
        parameters.add(currentUserId);
        parameters.add(timestamp);

        if (status > -1) {
            sSql.append(" and status = ? ");
            parameters.add(status);
        }

        /**
         * TODO offset
         */


        try (Connection conn = this.dbHander.getConnection();
             PreparedStatement ps = conn.prepareStatement(sSql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                ps.setObject(i + 1, parameters.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Message msg = new Message();
                    msg.setId(rs.getString(1));
                    msg.setType(MsgType.valueOf(rs.getString(2)));
                    msg.setFromUserId(rs.getString(3));
                    msg.setNickName(rs.getString(4));
                    msg.setContent(rs.getString(5));
                    msg.setToUserId(rs.getString(6));
                    msg.setTime(rs.getLong(7));
                    msg.setStatus(rs.getInt(8) == 0 ? MsgStatus.UNREAD : MsgStatus.READ);

                    String target = currentUserId.equals(msg.getFromUserId()) ? msg.getToUserId() : msg.getFromUserId();

                    List<Message> messages = chatList.get(target);
                    if (messages == null) {
                        messages = new ArrayList<>();
                        chatList.put(target, messages);
                    }
                    messages.add(msg);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatList;
    }
}
