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
    private Integer age;
    private Long gid;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gid=").append(gid);
        sb.append('}');
        return sb.toString();
    }
}
