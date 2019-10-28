package name.guolanren.controller;

import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/sys_user")
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
