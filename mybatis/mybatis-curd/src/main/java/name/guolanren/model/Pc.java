package name.guolanren.model;

import java.io.Serializable;

/**
 * @author guolanren
 */
public class Pc implements Serializable {

    private static final long serialVersionUID = 6432290268442336814L;

    private Long id;
    private String name;
    private Long belongTo;

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

    public Long getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(Long belongTo) {
        this.belongTo = belongTo;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", belongTo=" + belongTo +
                '}';
    }
}
