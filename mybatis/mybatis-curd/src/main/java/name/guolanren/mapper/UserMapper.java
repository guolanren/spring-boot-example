package name.guolanren.mapper;

import name.guolanren.model.User;
import name.guolanren.model.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserMapper {

    Long insert(User user);

    Long insertBatch(@Param("users") List<User> users);

    Long delete(Long id);

    Long update(User user);

    User get(@Param("id") Long id);

    UserVO getVO(@Param("id") Long id);
}
