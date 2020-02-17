import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: Jdbc_Base03
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/11  18:25
 */
public class Jdbc_Base03 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "123456");
            //sql
            String sql = "create table t_sys_tenant(id int,tenantname varchar(35))";
            //获取执行sql对象
            statement = conn.createStatement();
            //执行sql
            int count = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
