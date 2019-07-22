package name.guolanren.controller;

import name.guolanren.annotation.ApiAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author guolanren
 */
@RestController
public class SysUserController {

    @PostMapping("/login")
    @ApiAuditing(menu = "用户", type = "登录")
    public ResponseEntity login(@RequestParam("username") String username, HttpSession session) {
        session.setAttribute("CURRENT_USER", username);
        return ResponseEntity.ok(username);
    }

}
