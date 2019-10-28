package name.guolanren.scheduler;

import name.guolanren.service.ApiAuditingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author guolanren
 */
@Component
public class ApiAuditingCleaner {

    @Value("${auditing.retention.days:7}")
    private Integer retentionDays;

    @Autowired
    private ApiAuditingLogService auditLogService;

    @Scheduled(cron = "0 0 */1 * * *")
    public void cleanUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, Math.negateExact(retentionDays));
        auditLogService.cleanUp(calendar.getTime());
    }
}
