package name.guolanren.mapper;

import name.guolanren.model.User;
import name.guolanren.model.UserVO;

/**
 * @author guolanren
 */
public interface UserMapper {

    Long insert(User sysUser);


    Long delete(Long id);


    Long update(User sysUser);


    User get(Long id);

    UserVO getVO(Long id);
}
