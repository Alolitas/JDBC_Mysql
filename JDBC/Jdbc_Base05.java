import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JdbcBase
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/12  14:46
 *
 * 定义一个方法，查询t_sys_user表的数据将其封装为集合,返回
 */
public class Jdbc_Base05 {
    public static void main(String[] args) {
        List<SysUser> list = new Jdbc_Base05().quaryAll();
        System.out.println(list);
    }


    public List<SysUser> quaryAll() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        List<SysUser> list = null;

        try {
            //获取连接资源
            conn = JdbcUtils.getConnection();
            //定义sql
            String sql = "select * from userinfo;";
            //获取执行sql对象
            statement= JdbcUtils.getStatement();
            //执行sql
            rs = statement.executeQuery(sql);
            //遍历结果集，封装对象，装载集合
            //获取数据
            list = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                int phonenumber = rs.getInt("phonenumber");
                Date createdate = rs.getDate("createtime");
                //创建t_sys_user对象并赋值
                SysUser SysUser = new SysUser();
                SysUser.setId(id);
                SysUser.setUsername(username);
                SysUser.setPhonenumber(phonenumber);
                SysUser.setCreatetime(createdate);

                //装载集合
                list.add(SysUser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, statement, rs);
        }
        return list;
    }
}
