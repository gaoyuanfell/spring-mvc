package moka.user.to;

import java.io.Serializable;

/** 数据传输层
 * Created by moka on 2017/3/22.
 */
public class UserDetailTo implements Serializable {
    private int id;
    private String school;
    private String hobby;
    private String diploma;
    private String idCard;
    private String address;

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

    @Override
    public String toString() {
        return "UserDetailVo{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", hobby='" + hobby + '\'' +
                ", diploma='" + diploma + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
