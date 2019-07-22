package name.guolanren.service.impl;

import name.guolanren.entity.ApiAuditingLog;
import name.guolanren.repository.ApiAuditingRepository;
import name.guolanren.service.ApiAuditingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author guolanren
 */
@Service
public class ApiAuditingLogServiceImpl implements ApiAuditingLogService {

    @Autowired
    private ApiAuditingRepository apiAuditingRepository;

    @Override
    public List<ApiAuditingLog> getAll() {
        return apiAuditingRepository.findAll();
    }

    @Override
    public ApiAuditingLog generate(ApiAuditingLog apiAuditingLog) {
        return apiAuditingRepository.save(apiAuditingLog);
    }

    @Override
    public void cleanUp(Date expiredTime) {
        apiAuditingRepository.deleteByOperatedTimeBefore(expiredTime);
    }

}
