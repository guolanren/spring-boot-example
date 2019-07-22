package name.guolanren.repository;

import name.guolanren.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author guolanren
 */
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
}
