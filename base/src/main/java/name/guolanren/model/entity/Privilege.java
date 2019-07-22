package name.guolanren.model;

import com.alibaba.fastjson.annotation.JSONField;
import name.guolanren.model.validation.groups.CreateValidationGroup;
import name.guolanren.model.validation.groups.ModifyValidationGroup;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统权限
 *
 * @author guolanren
 */
public class Privilege implements Serializable {

    private static final long serialVersionUID = -1333800606185842874L;

    @NotNull(message = "权限ID不能为空", groups = {ModifyValidationGroup.class})
    @Positive(message = "权限ID不能小于0")
    private Long privilegeId;

    @JSONField(serialize = true, deserialize = false)
    private Date gmtCreate;

    @JSONField(serialize = true, deserialize = false)
    private Date gmtModified;

    @NotBlank(message = "权限名不能为空", groups = {CreateValidationGroup.class})
    @Length(min = 2, max = 18, message = "权限名长度最小2位，最大18位")
    private String name;

    @URL(message = "url格式不正确")
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
