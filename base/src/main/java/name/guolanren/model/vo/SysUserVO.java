package name.guolanren.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户 VO
 *
 * @author guolanren
 */
public class SysUserVO implements Serializable {

    private static final long serialVersionUID = 2398287594319788695L;

    private Long sysUserId;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private Integer deleted;

    private List<RoleVO> roles;

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public List<RoleVO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleVO> roles) {
        this.roles = roles;
    }

}
