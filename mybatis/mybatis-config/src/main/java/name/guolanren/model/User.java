package name.guolanren.model;

import org.apache.ibatis.type.Alias;

/**
 * @author guolanren
 */
@Alias("user")
public class User {

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
