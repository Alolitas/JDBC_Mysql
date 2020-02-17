import java.sql.*;

/**
 * @ClassName: Jdbc_Base
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/12  11:09
 */
public class Jdbc_Base04 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet rs=null;

        try {
            //获取连接资源
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "123456");
             //定义sql
            String sql = "select * from t_sys_user;";
            //获取执行sql对象
             statement = conn.createStatement();
             //执行sql
             rs = statement.executeQuery(sql);
             //处理查询结果
             //让鼠标向下移动一行
             rs.next();
             //获取第一行数据
             int id = rs.getInt(1);
             String username = rs.getString("username");
             int phonenumber = rs.getInt(3);
             Date date = rs.getDate(4);
             //打印第一行
             System.out.println(id + "---" + username + "---" + phonenumber + "---" + date);

             //游标向下移，获取第二行数据
             rs.next();
             int id2 = rs.getInt(1);
             String username2 = rs.getString("username");
             int phonenumber2 = rs.getInt(3);
             Date date2 = rs.getDate(4);
             //打印第二行
             System.out.println(id2 + "---" + username2 + "---" + phonenumber2 + "---" + date2);

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
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
