import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName: Jdbc_Base08
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/16  12:48
 *
 * 事务操作
 */
public class Jdbc_Base08 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pre1= null;
        PreparedStatement pre2= null;

        try {
            //获取连接
            conn = JdbcUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //定义sql
            String sql1 = "update salary set money = money-? where id = ?";
            String sql2 = "update salary set money = money+? where id = ?";
            //获取执行sql对象
            pre1 = conn.prepareStatement(sql1);
            pre2 = conn.prepareStatement(sql2);
            //设置参数
            pre1.setDouble(1,300);
            pre1.setInt(2,1001);
            pre2.setDouble(1,300);
            pre2.setInt(2,1002);
            //执行sql
            pre1.executeUpdate();
            pre2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
                try {
                    if(conn != null) {
                    conn.rollback();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,pre1);
            JdbcUtils.close(conn,pre2);
        }
    }

}
