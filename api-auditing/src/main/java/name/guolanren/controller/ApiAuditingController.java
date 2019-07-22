package name.guolanren.controller;

import name.guolanren.service.ApiAuditingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
public class ApiAuditingController {

    @Autowired
    private ApiAuditingLogService apiAuditingLogService;

    @GetMapping("/api_auditing")
    public ResponseEntity apiAuditing() {
        return ResponseEntity.ok(apiAuditingLogService.getAll());
    }

}
