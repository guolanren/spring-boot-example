package name.guolanren.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户角色 VO
 *
 * @author guolanren
 */
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 534019350845867449L;

    private Long roleId;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private List<PrivilegeVO> privileges;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public List<PrivilegeVO> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeVO> privileges) {
        this.privileges = privileges;
    }
}
