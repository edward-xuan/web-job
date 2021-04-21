package work.tool.classes.log;

import work.sql.JDBCUtil;
import work.tool.interfaces.log.UserLogItf;
import work.tool.property.log.UserProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserLog implements UserLogItf {
    UserProperty up = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public UserLog(UserProperty up) {
        this.up = up;
    }

    /**
     * 登录
     *
     * @return 登录成功或者失败
     */
    @Override
    public boolean login() {
        try {
            // 链接
            conn = JDBCUtil.getConn();
            // sql 语句
            String sql = "select * from `user` where email = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, up.email);
            ps.setString(2, up.password);

            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.replace(conn, ps, rs);
        }
        return false;
    }

    @Override
    public boolean singUp() {
        try {
            conn = JDBCUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select * from `user` where email = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, up.email);
            rs = ps.executeQuery();
            if (!rs.next()) {
                // 插入数据
                String sql1 = "insert into `user`(username, email, password) values (?, ?, ?)";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, up.username);
                ps.setString(2, up.email);
                ps.setString(3, up.password);
                ps.executeUpdate();
                conn.commit();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.replace(conn, ps, rs);
        }
        return false;
    }


    @Override
    public boolean update() {
        return false;
    }

    @Override
    public ArrayList<UserProperty> findNeed(int topLevel) {
        try {
            conn = JDBCUtil.getConn();
            String sql = "select * from `user` where `level` > ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, up.level);
            rs = ps.executeQuery();
            ArrayList<UserProperty> list = new ArrayList<>();
            while (rs.next()) {
                UserProperty up = new UserProperty();
                up.setUsername(rs.getString("username"));
                up.setEmail(rs.getString("email"));
                up.setPassword(rs.getString("password"));
                up.setLevel(rs.getInt("level"));
                list.add(up);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.replace(conn, ps, rs);
        }

        return null;
    }
}
