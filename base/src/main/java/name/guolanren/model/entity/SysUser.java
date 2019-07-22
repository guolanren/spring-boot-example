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
 * 系统用户
 *
 * @author guolanren
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = -7892689167986293690L;

    @NotNull(message = "系统用户ID不能为空", groups = {ModifyValidationGroup.class})
    @Positive(message = "系统用户ID不能小于0")
    private Long sysUserId;

    @JSONField(serialize = true, deserialize = false)
    private Date gmtCreate;

    @JSONField(serialize = true, deserialize = false)
    private Date gmtModified;

    @NotBlank(message = "系统用户名不能为空", groups = {CreateValidationGroup.class})
    @Length(min = 1, max = 8, message = "系统用户名长度最小1位，最大8位")
    private String name;

    @JSONField(serialize = false, deserialize = false)
    private Integer deleted;

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

}
