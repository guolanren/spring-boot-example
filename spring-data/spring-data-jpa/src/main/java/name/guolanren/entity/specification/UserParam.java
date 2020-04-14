package name.guolanren.model.specification;

import java.util.Date;

/**
 * @author guolanren
 */
public class UserParam {

    private Integer id;

    private String name;

    private String nickname;

    private Date createTime;

    private Date beginCreateTime;

    private Date endCreateTime;

    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
