package moka.comment.vo;

import moka.basic.page.Page;
import moka.branch.vo.BranchVo;
import moka.line.vo.LineVo;
import moka.lineSend.to.LineSendTo;
import moka.reply.bo.Reply;
import moka.user.vo.UserVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class CommentVo extends Page {
    private int id;
    private int branchId;
    private int lineId;
    private int lineSendId;
    private int userId;
    private int replyId;
    private BranchVo branch;
    private LineVo line;
    private LineSendTo lineSend;
    private UserVo user;
    private Reply reply;
    private String context;
    private int praised;
    private int review;
    private int forward;
    private Date createDate;
    private Date updateDate;
    private int state;
    private int type;

    //运算类型 为true 减法 默认加法
    private boolean operationType;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isOperationType() {
        return operationType;
    }

    public void setOperationType(boolean operationType) {
        this.operationType = operationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
