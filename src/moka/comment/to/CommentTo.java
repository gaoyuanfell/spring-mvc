package moka.comment.to;

import moka.branch.to.BranchTo;
import moka.line.to.LineTo;
import moka.lineSend.to.LineSendTo;
import moka.reply.bo.Reply;
import moka.reply.to.ReplyTo;
import moka.user.to.UserTo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class CommentTo implements Serializable {
    private int id;
    private int branchId;
    private int lineId;
    private int lineSendId;
    private int userId;
    private List<ReplyTo> replies;
    private BranchTo branch;
    private LineTo line;
    private LineSendTo lineSend;
    private UserTo user;
    private Reply reply;
    private String context;
    private int praised;
    private int review;
    private int forward;
    private Date createDate;
    private Date updateDate;
    private int state;
    private int type;

    private int isPraised;//指定用户是否点赞
    private int isForward;//指定用户是否分享

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public List<ReplyTo> getReplies() {
        return replies;
    }

    public void setReplies(List<ReplyTo> replies) {
        this.replies = replies;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
