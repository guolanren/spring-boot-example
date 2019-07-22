package name.guolanren.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统权限 VO
 *
 * @author guolanren
 */
public class PrivilegeVO implements Serializable {

    private static final long serialVersionUID = -6078706675170521202L;

    private Long privilegeId;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private String url;

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
