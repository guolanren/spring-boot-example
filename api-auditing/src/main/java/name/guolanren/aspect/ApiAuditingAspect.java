package name.guolanren.aspect;

import name.guolanren.annotation.ApiAuditing;
import name.guolanren.entity.ApiAuditingLog;
import name.guolanren.service.ApiAuditingLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author guolanren
 */
@Aspect
@Component
public class ApiAuditingAspect {

    @Autowired
    private ApiAuditingLogService apiAuditingLogService;

    @Around("@annotation(apiAuditing)")
    public ResponseEntity aroundOperating(ProceedingJoinPoint joinPoint, ApiAuditing apiAuditing) throws Throwable {
        ResponseEntity responseEntity;
        ApiAuditingLog apiAuditingLog = new ApiAuditingLog();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        apiAuditingLog.setIp(request.getRemoteAddr());
        apiAuditingLog.setMenu(apiAuditing.menu());
        apiAuditingLog.setType(apiAuditing.type());
        apiAuditingLog.setOperatedTime(new Date());
        try {
            responseEntity = (ResponseEntity) joinPoint.proceed();
            apiAuditingLog.setStatus(responseEntity.getStatusCodeValue());
            apiAuditingLog.setDescription(responseEntity.getBody().toString());
        } catch (Throwable e) {
            apiAuditingLog.setStatus(-1);
            apiAuditingLog.setDescription(e.getMessage());
            throw e;
        } finally {
            Object object = request.getSession().getAttribute("CURRENT_USER");
            if (object == null) {
                apiAuditingLog.setUsername("unknown");
            } else {
                apiAuditingLog.setUsername((String) object);
            }
            apiAuditingLogService.generate(apiAuditingLog);
        }
        return responseEntity;
    }

}
