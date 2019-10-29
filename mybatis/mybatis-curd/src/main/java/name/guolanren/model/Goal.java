package name.guolanren.model;

import java.io.Serializable;

/**
 * @author guolanren
 */
public class Goal implements Serializable {

    private static final long serialVersionUID = -2153205434849814326L;

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

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
