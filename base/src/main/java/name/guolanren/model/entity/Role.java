package name.guolanren.model;

import com.alibaba.fastjson.annotation.JSONField;
import name.guolanren.model.validation.groups.CreateValidationGroup;
import name.guolanren.model.validation.groups.ModifyValidationGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色
 *
 * @author guolanren
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -5857407603958163389L;

    @NotNull(message = "角色ID不能为空", groups = {ModifyValidationGroup.class})
    @Positive(message = "角色ID不能小于0")
    private Long roleId;

    @JSONField(serialize = true, deserialize = false)
    private Date gmtCreate;

    @JSONField(serialize = true, deserialize = false)
    private Date gmtModified;

    @NotBlank(message = "角色名不能为空", groups = {CreateValidationGroup.class})
    @Length(min = 2, max = 8, message = "角色名长度最小2位，最大8位")
    private String name;

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

}
