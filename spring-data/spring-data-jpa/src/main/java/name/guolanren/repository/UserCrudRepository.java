package name.guolanren.repository;

import name.guolanren.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author guolanren
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {
}
