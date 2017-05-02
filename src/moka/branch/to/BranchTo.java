package moka.branch.to;

import moka.line.to.LineTo;
import moka.user.to.UserTo;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class BranchTo implements Serializable {
    private int id;
    private LineTo line;
    private int lineId;
    private int userId;
    private UserTo user;
    private String title;
    private String introduce;
    private String url;
    private String[] urls;
    private String lng;
    private String lat;
    private Date createDate;
    private Date updateDate;
    private int state;

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserTo getUser() {
        return user;
    }

    public void setUser(UserTo user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LineTo getLine() {
        return line;
    }

    public void setLine(LineTo line) {
        this.line = line;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if(!StringUtils.isEmpty(url)){
            this.setUrls(url.split(","));
        }
        this.url = url;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }
}
