package moka.line.to;

import moka.branch.to.BranchTo;
import moka.user.to.UserTo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class LineTo implements Serializable {
    private int id;
    private UserTo user;
    private int userId;
    private String title;
    private String introduce;
    private int praised;
    private int review;
    private int forward;
    private int privacy;
    private Date createDate;
    private Date updateDate;
    private int state;
    private List<BranchTo> branch;

    private int isPraised;//指定用户是否点赞
    private int isForward;//指定用户是否分享

    //合并线路转发的字段
    private int lineId;
    private String context;

    public List<BranchTo> getBranch() {
        return branch;
    }

    public void setBranch(List<BranchTo> branch) {
        this.branch = branch;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getIsPraised() {
        return isPraised;
    }

    public void setIsPraised(int isPraised) {
        this.isPraised = isPraised;
    }

    public int getIsForward() {
        return isForward;
    }

    public void setIsForward(int isForward) {
        this.isForward = isForward;
    }

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

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
