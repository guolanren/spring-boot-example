package name.guolanren.repository;

import name.guolanren.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author guolanren
 */
public interface UserQueryByExampleRepository extends JpaRepository<User, Long> {
}
