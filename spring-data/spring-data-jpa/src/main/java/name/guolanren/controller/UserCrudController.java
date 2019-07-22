package name.guolanren.controller;

import name.guolanren.entity.User;
import name.guolanren.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/crud")
public class UserCrudController {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @PostMapping("/save")
    public Object save(@RequestBody User user) {
        return userCrudRepository.save(user);
    }

    @PostMapping("/saveAll")
    public Object saveAll(@RequestBody List<User> users) {
        return userCrudRepository.saveAll(users);
    }

    @GetMapping("/findById")
    public Object findById(Long id) {
        User u = userCrudRepository.findById(id).get();
        return u;
    }

    @GetMapping("/existsById")
    public Object existsById(Long id) {
        return userCrudRepository.existsById(id);
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return userCrudRepository.findAll();
    }

    @GetMapping("/findAllById")
    public Object findAllById(@RequestParam("ids") List<Long> ids) {
        return userCrudRepository.findAllById(ids);
    }

    @GetMapping("/count")
    public Object count() {
        return userCrudRepository.count();
    }

    @DeleteMapping("/deleteById")
    public void deleteById(Long id) {
        userCrudRepository.deleteById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody User user) {
        userCrudRepository.delete(user);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(@RequestBody List<User> users) {
        userCrudRepository.deleteAll(users);
    }

    @DeleteMapping("/deleteAlls")
    public void deleteAll() {
        userCrudRepository.deleteAll();
    }
}
