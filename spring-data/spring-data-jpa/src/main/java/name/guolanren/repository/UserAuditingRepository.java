package name.guolanren.repository;

import name.guolanren.entity.auditing.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author guolanren
 */
public interface UserAuditingRepository extends JpaRepositoryImplementation<User, Integer> {
}
