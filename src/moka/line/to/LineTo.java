package moka.line.to;

import moka.user.to.UserTo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class LineTo implements Serializable {
    private int id;
    private UserTo user;
    private String title;
    private String introduce;
    private Date createDate;
    private Date updateDate;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserTo getUser() {
        return user;
    }

    public void setUser(UserTo user) {
        this.user = user;
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
        return "LineTo{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state=" + state +
                '}';
    }
}
