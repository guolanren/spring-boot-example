package name.guolanren.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

/**
 * @author guolanren
 */
@Alias("UserVO")
public class UserVO implements Serializable {

    private static final long serialVersionUID = -1432622704077389569L;

    private Long id;
    private String name;
    private Goal goal;
    private List<Pc> pcs;
    private List<Language> languages;

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

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public List<Pc> getPcs() {
        return pcs;
    }

    public void setPcs(List<Pc> pcs) {
        this.pcs = pcs;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goal=" + goal +
                ", pcs=" + pcs +
                ", languages=" + languages +
                '}';
    }
}
