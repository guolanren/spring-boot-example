package name.guolanren.repository;

import name.guolanren.model.auditing.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author guolanren
 */
public interface UserAuditingRepository extends JpaRepositoryImplementation<User, Integer> {
}
