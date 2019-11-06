package name.guolanren.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author guolanren
 */
@Alias("User")
public class User implements Serializable {

    private static final long serialVersionUID = 1494806858707788933L;

    private Long id;
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
