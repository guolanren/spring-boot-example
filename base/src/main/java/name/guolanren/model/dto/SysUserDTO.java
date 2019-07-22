package name.guolanren.model.dto;

import java.io.Serializable;

/**
 * 系统用户 DTO
 *
 * @author guolanren
 */
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 4291639945191538794L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
