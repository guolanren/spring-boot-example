package name.guolanren.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * @author guolanren
 */
@TableName(value = "example_user")
public class User implements Serializable {

    private static final long serialVersionUID = -1238170791719575461L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "is_deleted")
    @TableLogic(value = "0", delval = "1")
    private Boolean deleted;


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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
