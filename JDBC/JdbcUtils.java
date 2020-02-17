import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName: JdbcUtils
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/14  14:13
 *
 *jdbc工具类，用于封装jdbc操作数据库的重复代码
 */
public class JdbcUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //数据库连接信息可以放在配置文件中
    //配置文件只需要读取一次就可以拿到这些数据，可以写在静态代码块中
    static{
        try {
            //创建properties集合类
            Properties pro = new Properties();
            //获取src路径下文件的方式---classloader加载器
            ClassLoader loader = JdbcUtils.class.getClassLoader();
            URL res = loader.getResource("jdbcinfo.properties");
            String path = res.getPath();
            pro.load(new FileReader(path));

            //获取数据并赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接方法
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     *获取执行sql对象
     * @return
     * @throws SQLException
     */
    public static Statement getStatement() throws SQLException {
        return  JdbcUtils.getConnection().createStatement();
    }


    /**
     * 释放资源
     * @param conn
     * @param state
     */
    public static void close(Connection conn,Statement state)  {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param conn
     * @param state
     * @param ret
     */
    public static void close(Connection conn, Statement state, ResultSet ret){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ret != null){
            try {
                ret.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
