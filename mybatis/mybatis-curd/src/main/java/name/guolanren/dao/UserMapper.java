package name.guolanren.dao;

import name.guolanren.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author guolanren
 */
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO user (name) " +
            "VALUES (#{name})")
    Long insert(User sysUser);

    @Delete("DELETE FROM user WHERE id = #{id}")
    Long delete(Long id);

    @Update("UPDATE user " +
            " SET name = #{name}" +
            "WHERE id = #{id} ")
    Long update(User sysUser);

    @Select("SELECT id, name" +
            "FROM user " +
            "WHERE id = #{id} ")
    User findById(Long id);
}
