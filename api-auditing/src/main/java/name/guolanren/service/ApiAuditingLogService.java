package name.guolanren.service;

import name.guolanren.entity.ApiAuditingLog;

import java.util.Date;
import java.util.List;

/**
 * @author guolanren
 */
public interface ApiAuditingLogService {

    List<ApiAuditingLog> getAll();

    ApiAuditingLog generate(ApiAuditingLog apiAuditingLog);

    void cleanUp(Date expiredTime);
}
