package moka.comment.bo;

import moka.basic.bo.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by moka on 2017/4/20 0020.
 */
@Entity
@Table(name = "commentRelation")
public class CommentRelation extends IdEntity {
    private int type;
    private int comType;
    private int userId;
    private int lineId;
    private int lineSendId;
    private int replyId;
    private int commentId;
    private int branchId;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getComType() {
        return comType;
    }

    public void setComType(int comType) {
        this.comType = comType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getLineSendId() {
        return lineSendId;
    }

    public void setLineSendId(int lineSendId) {
        this.lineSendId = lineSendId;
    }
}
