package moka.user.vo;

import moka.basic.page.Page;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by moka on 2017/3/22.
 */
public class UserDetailVo extends Page implements Serializable {
    private int id;
    private String school;
    private String hobby;
    private String diploma;
    private String idCard;
    private String address;
    private Date createDate;
    private Date updateDate;
    private int state;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
        return "UserDetailVo{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", hobby='" + hobby + '\'' +
                ", diploma='" + diploma + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", state=" + state +
                '}';
    }
}
