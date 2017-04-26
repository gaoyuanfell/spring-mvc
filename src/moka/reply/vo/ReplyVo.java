package moka.reply.vo;

import moka.basic.page.Page;
import moka.branch.to.BranchTo;
import moka.line.to.LineTo;
import moka.lineSend.to.LineSendTo;
import moka.user.to.UserTo;
import moka.user.vo.UserVo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/4/6 0006.
 */
public class ReplyVo extends Page {
    private int id;
    private int branchId;
    private int lineId;
    private int lineSendId;
    private int userId;
    private BranchTo branch;
    private LineTo line;
    private LineSendTo lineSend;
    private UserTo user;
    private String context;
    private int praised;
    private Date createDate;
    private Date updateDate;
    private int state;

    //运算类型 为true 减法 默认加法
    private boolean operationType;

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

    public int getLineSendId() {
        return lineSendId;
    }

    public void setLineSendId(int lineSendId) {
        this.lineSendId = lineSendId;
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

    public LineSendTo getLineSend() {
        return lineSend;
    }

    public void setLineSend(LineSendTo lineSend) {
        this.lineSend = lineSend;
    }

    public UserTo getUser() {
        return user;
    }

    public void setUser(UserTo user) {
        this.user = user;
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
}
