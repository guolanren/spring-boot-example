package name.guolanren.mapper;

import name.guolanren.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserMapper {

    Long insert(User user);

    User get(Long id);
}
