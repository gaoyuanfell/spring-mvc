package moka.line.bo;

import moka.basic.bo.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Entity
@Table(name = "line")
public class Line extends IdEntity{
    private int userId;
    private String title;
    private String introduce;
    private Date createDate;

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
        return "Line{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
