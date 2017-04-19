package moka.comment.to;

import moka.branch.to.BranchTo;
import moka.line.to.LineTo;
import moka.user.to.UserTo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class CommentTo implements Serializable {
    private int id;
    private int branchId;
    private int lineId;
    private int userId;
    private BranchTo branch;
    private LineTo line;
    private UserTo user;
    private int praised;
    private int repeat;
    private int forward;
    private Date createDate;
    private Date updateDate;
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
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

    public BranchTo getBranch() {
        return branch;
    }

    public void setBranch(BranchTo branch) {
        this.branch = branch;
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

    public int getPraised() {
        return praised;
    }

    public void setPraised(int praised) {
        this.praised = praised;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getForward() {
        return forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
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
        return "CommentTo{" +
                "id=" + id +
                ", branchId=" + branchId +
                ", lineId=" + lineId +
                ", userId=" + userId +
                ", branch=" + branch +
                ", line=" + line +
                ", user=" + user +
                ", praised=" + praised +
                ", repeat=" + repeat +
                ", forward=" + forward +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state=" + state +
                '}';
    }
}
