package name.guolanren.model.dto;

import java.io.Serializable;

/**
 * 系统权限 DTO
 *
 * @author guolanren
 */
public class PrivilegeDTO implements Serializable {

    private static final long serialVersionUID = 3201409013237890799L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
