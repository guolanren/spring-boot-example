package name.guolanren.controller;

import name.guolanren.model.auditing.User;
import name.guolanren.repository.UserAuditingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/auditing")
public class UserAuditingController {

    @Autowired
    private UserAuditingRepository userAuditingRepository;

    @PostMapping("/save")
    public Object save(@RequestBody User user) {
        return userAuditingRepository.save(user);
    }

    @PutMapping("/update")
    public Object update(@RequestBody User user) {
        return userAuditingRepository.save(user);
    }

}
