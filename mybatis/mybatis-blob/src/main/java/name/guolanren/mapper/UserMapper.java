package name.guolanren.mapper;

import name.guolanren.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserMapper {

    Long insert(User sysUser);

    User get(Long id);
}
