package name.guolanren.model;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * @author guolanren
 */
@TableName(value = "example_sys_user")
@KeySequence(value = "SEQ_SYS_USER", clazz = String.class)
public class SysUser implements Serializable {

    private static final long serialVersionUID = -1238170791719575461L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    @TableField(value = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return "SysUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
