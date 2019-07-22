package name.guolanren.model.dto;

import java.io.Serializable;

/**
 * 用户角色 DTO
 *
 * @author guolanren
 */
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -3409440116807585692L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
