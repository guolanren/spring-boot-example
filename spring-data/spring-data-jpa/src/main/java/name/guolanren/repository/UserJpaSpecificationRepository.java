package name.guolanren.repository;

import name.guolanren.entity.specification.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author guolanren
 */
public interface UserJpaSpecificationRepository extends JpaRepositoryImplementation<User, Integer> {
}
