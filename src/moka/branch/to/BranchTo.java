package moka.branch.to;

import moka.line.to.LineTo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class BranchTo implements Serializable {
    private int id;
    private LineTo line;
    private String title;
    private String introduce;
    private String url;
    private String lng;
    private String lat;
    private Date createDate;
    private Date updateDate;
    private int state;

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

    @Override
    public String toString() {
        return "BranchTo{" +
                "id=" + id +
                ", line=" + line +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", url='" + url + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state=" + state +
                '}';
    }
}
