package moka.comment.bo;

import moka.basic.bo.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Entity
@Table(name = "comment")
public class Comment extends IdEntity {
    private int branchId;
    private int lineId;
    private int userId;
    private String context;
    private int praised;
    private int repeat;
    private int forward;

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

    @Override
    public String toString() {
        return "Comment{" +
                "branchId=" + branchId +
                ", lineId=" + lineId +
                ", userId=" + userId +
                ", context='" + context + '\'' +
                ", praised=" + praised +
                ", repeat=" + repeat +
                ", forward=" + forward +
                ", createDate=" + createDate +
                '}';
    }
}
