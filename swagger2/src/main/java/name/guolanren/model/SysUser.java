package name.guolanren.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author guolanren
 */
@ApiModel(value = "SysUser")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 2905709529688733957L;

    @ApiModelProperty(value = "系统用户 ID", example = "1")
    private Long id;
    @ApiModelProperty(value = "系统用户名", example = "甲")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
