package name.guolanren.controller;

import name.guolanren.entity.User;
import name.guolanren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllByRestTemplate")
    public Object getAllByRestTemplate() {
        return userService.getAllByRestTemplate();
    }

    @GetMapping("/getAllByValueOperations")
    public Object getAllByValueOperations() {
        return userService.getAllByValueOperations();
    }

    @GetMapping("/getById")
    public Object getById(@RequestParam Long id) {
        return userService.getById(id);
    }

    @PutMapping("/update")
    public Object update(@RequestBody User user) {
        userService.update(user);
        return "success";
    }

    @DeleteMapping("/delete")
    public Object delete(@RequestParam Long id) {
        userService.delete(id);
        return "success";
    }
}
