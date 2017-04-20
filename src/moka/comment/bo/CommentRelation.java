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
    private int comType;
    private int userId;
    private int lineId;
    private int commentId;

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
}
