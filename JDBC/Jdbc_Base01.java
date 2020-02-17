import java.sql.*;

/**
 * @ClassName: Jdbc_Base
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/10  14:27
 */
public class Jdbc_Base01 {
    public static void main(String[] args) throws Exception {
        //1、导入驱动jar包
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取数据库连接资源
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "123456");
        //4、定义sql语句
        String sql = "update t_sys_user set username='汉堡王' where id =202001";
        //5、获取执行sql的对象 statement
        Statement statement = conn.createStatement();
        //6、执行sql
        int count = statement.executeUpdate(sql);
        //处理结果,返回修改成功数量
        System.out.println(count);
        //关闭资源
        conn.close();
        statement.close();

    }


}
