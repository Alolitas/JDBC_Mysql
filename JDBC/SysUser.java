import java.util.Date;

/**
 * @ClassName: UserEmp
 * @Description: TODO
 * @author: Doge_fang
 * @date: 2020/2/12  14:35
 *
 * 封装表数据的javabean
 */
public class SysUser {

    private int id;
    private String username;
    private int phonenumber;
    private Date createtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "UserEmp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phonenumber=" + phonenumber +
                ", createtime=" + createtime +
                '}';
    }
}
