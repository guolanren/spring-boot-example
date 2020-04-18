package name.guolanren.service;

import name.guolanren.model.User;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserService {

    Long insert(User user);

    Long delete(Long id);

    Long update(User user);

    User get(Long id);

    List<User> getAll();
}
