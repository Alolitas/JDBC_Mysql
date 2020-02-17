import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @ClassName: Jdbc_Base06
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/15  12:48
 *
 * 1、通过键盘录入用户名和密码
 * 2、判断用户是否登录成功
 */
public class Jdbc_Base06 {
    public static void main(String[] args) {
        //接收用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String passwd = scanner.nextLine();
        //调用登录方法
        Boolean loginflag = new Jdbc_Base06().login(username, passwd);
        if(loginflag){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    //登录
    public Boolean login(String loginname,String passwd){
        Connection conn = null;
        Statement state = null;
        ResultSet res = null;
        //若用户名或密码为空，返回flase
        if(loginname == null || passwd == null){
            return false;
        }
        //若都不为空
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from userlogin where loginname = '" + loginname + "' and passwd = '" + passwd + "' ";
            state = JdbcUtils.getStatement();
            res = state.executeQuery(sql);
            //判断如果查询有下一行则返回结果
            if(res.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,state,res);
        }
        return false;
    }
}
