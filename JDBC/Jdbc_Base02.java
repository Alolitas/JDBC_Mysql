import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: Jdbc_Base02
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/10  15:15
 */
public class Jdbc_Base02 {

    public static void main(String[] args) {

        Statement statement =null;
        Connection conn =null;


        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接资源
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "123456");
            //sql
            String sql = "insert into t_sys_user values(202005,'必胜客',1377135820,null)";
            //获取sql对象
             statement = conn.createStatement();
            //执行sql
            int count = statement.executeUpdate(sql);
            //打印成功执行数
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源，先判断是否空指针
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
