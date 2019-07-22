package name.guolanren.repository;

import name.guolanren.entity.ApiAuditingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * @author guolanren
 */
public interface ApiAuditingRepository extends JpaRepository<ApiAuditingLog, Integer> {

    void deleteByOperatedTimeBefore(Date expiredTime);

}
