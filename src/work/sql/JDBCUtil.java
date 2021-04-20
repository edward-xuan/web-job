package work.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;

    static {
        try {
            // 配置对象
            Properties properties = new Properties();

            // 类加载器，读取 src 下的 jdbc.properties
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

            // 导入
            properties.load(is);

            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            name = properties.getProperty("name");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接对象
     *
     * @return 链接
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            // 通过类名新建对象
            Class.forName(driverClass);
            // 建立链接
            conn = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn Connection
     * @param st   Statement
     * @param rs   ResultSet
     */
    public static void replace(Connection conn, Statement st, ResultSet rs) {
        closeConn(conn);
        closeRs(rs);
        closeSt(st);
    }

    public static void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeSt(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
