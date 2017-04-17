package moka.comment.vo;

import moka.basic.page.Page;
import moka.branch.vo.BranchVo;
import moka.line.vo.LineVo;
import moka.user.vo.UserVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class CommentVo extends Page implements Serializable {
    private int id;
    private int branchId;
    private int lineId;
    private int userId;
    private BranchVo branch;
    private LineVo line;
    private UserVo user;
    private int praised;
    private int repeat;
    private int forward;
    private Date createDate;

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

    public BranchVo getBranch() {
        return branch;
    }

    public void setBranch(BranchVo branch) {
        this.branch = branch;
    }

    public LineVo getLine() {
        return line;
    }

    public void setLine(LineVo line) {
        this.line = line;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
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

    @Override
    public String toString() {
        return "CommentVo{" +
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
                '}';
    }
}
