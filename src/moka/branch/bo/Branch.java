package moka.branch.bo;

import moka.basic.bo.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Entity
@Table(name = "branch")
public class Branch extends IdEntity {
    private int lineId;
    private String title;
    private String introduce;
    private String url;
    private String lng;
    private String lat;
    private String scope;

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "lineId=" + lineId +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", url='" + url + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", scope='" + scope + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
