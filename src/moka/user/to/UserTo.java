package moka.user.to;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回数据
 * Created by moka on 2017/3/5 0005.
 */
public class UserTo implements Serializable {
    private int id;
    private String user;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String nickName;
    private UserDetailTo userDetail;
    private Date createDate;
    private Date updateDate;
    private int state;

    public UserDetailTo getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailTo userDetail) {
        this.userDetail = userDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userDetail=" + userDetail +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state=" + state +
                '}';
    }
}
