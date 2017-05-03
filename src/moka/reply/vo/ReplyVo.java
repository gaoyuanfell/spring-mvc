package moka.reply.vo;

import moka.basic.page.Page;
import moka.branch.to.BranchTo;
import moka.comment.to.CommentTo;
import moka.line.to.LineTo;
import moka.lineSend.to.LineSendTo;
import moka.user.to.UserTo;

import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class ReplyVo extends Page {
    private int id;
    private Date createDate;
    private Date updateDate;
    private int state;
    private int commentId;
    private CommentTo comment;
    private int branchId;
    private BranchTo branch;
    private int lineId;
    private LineTo line;
    private int lineSendId;
    private LineSendTo lineSend;
    private int userId;
    private UserTo user;
    private int userToId;
    private UserTo userTo;
    private String context;
    private int praised;

    //运算类型 为true 减法 默认加法
    private boolean operationType;

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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public CommentTo getComment() {
        return comment;
    }

    public void setComment(CommentTo comment) {
        this.comment = comment;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public BranchTo getBranch() {
        return branch;
    }

    public void setBranch(BranchTo branch) {
        this.branch = branch;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public LineTo getLine() {
        return line;
    }

    public void setLine(LineTo line) {
        this.line = line;
    }

    public int getLineSendId() {
        return lineSendId;
    }

    public void setLineSendId(int lineSendId) {
        this.lineSendId = lineSendId;
    }

    public LineSendTo getLineSend() {
        return lineSend;
    }

    public void setLineSend(LineSendTo lineSend) {
        this.lineSend = lineSend;
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

    public int getUserToId() {
        return userToId;
    }

    public void setUserToId(int userToId) {
        this.userToId = userToId;
    }

    public UserTo getUserTo() {
        return userTo;
    }

    public void setUserTo(UserTo userTo) {
        this.userTo = userTo;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getPraised() {
        return praised;
    }

    public void setPraised(int praised) {
        this.praised = praised;
    }

    public boolean isOperationType() {
        return operationType;
    }

    public void setOperationType(boolean operationType) {
        this.operationType = operationType;
    }
}
