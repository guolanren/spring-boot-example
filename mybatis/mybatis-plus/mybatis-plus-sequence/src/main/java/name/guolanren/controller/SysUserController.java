package name.guolanren.controller;

import com.leayun.bdc.model.SysUser;
import com.leayun.bdc.service.SysUserService;
import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户 Controller
 *
 * @author 郭耀展
 */
@RestController
@RequestMapping("/sys_users")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    public ResponseEntity create(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok(sysUserService.create(sysUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        sysUserService.remove(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping
    public ResponseEntity modify(@RequestBody SysUser sysUser) {
        sysUserService.modify(sysUser);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(sysUserService.getById(id));
    }
}
