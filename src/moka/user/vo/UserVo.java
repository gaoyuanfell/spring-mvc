package moka.user.vo;

import moka.basic.page.Page;
import moka.user.to.UserDetailTo;

import java.io.Serializable;
import java.util.Date;

/**
 * 接收应用层的数据
 * Created by moka on 2017/3/5 0005.
 */
public class UserVo extends Page implements Serializable {
    private int id;
    private String user;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String nickName;
    private String url;
    private UserDetailVo userDetail;
    private int userDetailId;
    private Date createDate;
    private Date updateDate;
    private int state;

    public UserDetailVo getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailVo userDetail) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
