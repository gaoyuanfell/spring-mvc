package moka.branch.to;

import moka.line.to.LineTo;
import moka.user.to.UserTo;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class BranchTo implements Serializable {
    private int id;
    private Date createDate;
    private Date updateDate;
    private int state;
    private int lineId;
    private int userId;
    private LineTo line;
    private UserTo user;
    private String title;
    private String introduce;
    private int privacy;
    private int praised;
    private int review;
    private String url;
    private String wh;
    private String[] urls;
    private String[] whs;
    private String lng;
    private String lat;
    private int scope;
    private List<Img> imgs = new ArrayList<>();

    public List<Img> getImgs() {
        return imgs;
    }

    public void setImgs(List<Img> imgs) {
        this.imgs = imgs;
    }

    public String[] getWhs() {
        return whs;
    }

    public void setWhs(String[] whs) {
        this.whs = whs;
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        if(!StringUtils.isEmpty(wh) && !StringUtils.isEmpty(this.getUrl())){
            String[] whs = wh.split(",");
            String[] urls = this.getUrl().split(",");

            for (int a = 0; a < urls.length; a++){
                String[] w = whs[a].split("\\*");
                imgs.add(new Img(urls[a],w[0],w[1]));
            }
        }
        this.wh = wh;
    }

    private int isPraised;//指定用户是否点赞

    public int getIsPraised() {
        return isPraised;
    }

    public void setIsPraised(int isPraised) {
        this.isPraised = isPraised;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LineTo getLine() {
        return line;
    }

    public void setLine(LineTo line) {
        this.line = line;
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

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public int getPraised() {
        return praised;
    }

    public void setPraised(int praised) {
        this.praised = praised;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
//        if (!StringUtils.isEmpty(url)) {
//            this.setUrls(url.split(","));
//        }
        if(!StringUtils.isEmpty(url) && !StringUtils.isEmpty(this.getWh())){
            String[] whs = this.getWh().split(",");
            String[] urls = url.split(",");

            for (int a = 0; a < urls.length; a++){
                String[] w = whs[a].split("\\*");
                imgs.add(new Img(urls[a],w[0],w[1]));
            }
        }
        this.url = url;
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
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

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}
