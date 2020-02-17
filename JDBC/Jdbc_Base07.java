import java.sql.*;
import java.util.Scanner;

/**
 * @ClassName: Jdbc_Base07
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/15  15:43
 *
 * 登录方法使用preparestatement
 */
public class Jdbc_Base07 {

    public static void main(String[] args) {
        //接收用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String passwd = scanner.nextLine();
        //调用登录方法
        Boolean loginflag = new Jdbc_Base07().login2(username, passwd);
        if(loginflag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    //登录
    public Boolean login2(String loginname,String passwd){
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        //若用户名或密码为空，返回flase
        if(loginname == null || passwd == null){
            return false;
        }
        //若都不为空
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from userlogin where loginname = ? and passwd = ? ";
            //获取执行sql对象
            pre = conn.prepareStatement(sql);
            //给 ？ 赋值
            pre.setString(1,"loginname");
            pre.setString(2,"passwd");
            //执行查询，不需要传递sql
            res = pre.executeQuery();
            //判断如果查询有下一行则返回结果
            if(res.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,pre,res);
        }
        return false;
    }
}
