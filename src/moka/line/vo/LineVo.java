package moka.line.vo;

import moka.basic.page.Page;
import moka.user.vo.UserVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class LineVo extends Page implements Serializable {
    private int id;
    private UserVo user;
    private int userId;
    private String title;
    private String introduce;
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LineVo{" +
                "id=" + id +
                ", user=" + user +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
