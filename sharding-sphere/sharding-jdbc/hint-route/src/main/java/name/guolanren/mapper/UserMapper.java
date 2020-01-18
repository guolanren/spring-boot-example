package name.guolanren.mapper;

import name.guolanren.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author guolanren
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user")
    Set<User> list();

}
