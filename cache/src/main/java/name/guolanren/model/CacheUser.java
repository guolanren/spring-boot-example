package name.guolanren.model;

import java.io.Serializable;

/**
 * @author guolanren
 */
public class CacheUser implements Serializable {

    private static final long serialVersionUID = 281911666095614238L;
    private Long id;
    private String name;

    public CacheUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
