package name.guolanren.dao;

import com.github.pagehelper.Page;
import name.guolanren.model.SysUser;
import org.apache.ibatis.annotations.Select;


/**
 * @author guolanren
 */
public interface SysUserMapper {

    @Select("SELECT * FROM example_sys_user")
    Page<SysUser> find();

}
