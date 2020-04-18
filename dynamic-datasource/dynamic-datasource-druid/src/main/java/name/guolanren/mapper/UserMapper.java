package name.guolanren.mapper;

import name.guolanren.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserMapper {

    Long insert(User user);

    Long delete(@Param("id") Long id);

    Long update(User user);

    User get(@Param("id") Long id);

    List<User> getAll();

}
