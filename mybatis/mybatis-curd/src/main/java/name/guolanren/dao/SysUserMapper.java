package name.guolanren.dao;

import name.guolanren.model.SysUser;
import org.apache.ibatis.annotations.*;

/**
 * @author guolanren
 */
public interface SysUserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO example_sys_user (name, gmt_create, gmt_modified) " +
            "VALUES (#{name}, #{gmtCreate}, #{gmtModified})")
    Long insert(SysUser sysUser);

    @Delete("DELETE FROM example_sys_user WHERE id = #{id}")
    Long delete(Long id);

    @Update("UPDATE example_sys_user " +
            " SET name = #{name}, gmt_modified = #{gmtModified} " +
            "WHERE id = #{id} ")
    Long update(SysUser sysUser);

    @Select("SELECT id, name, gmt_create, gmt_modified " +
            "FROM example_sys_user " +
            "WHERE id = #{id} ")
    SysUser findById(Long id);
}
