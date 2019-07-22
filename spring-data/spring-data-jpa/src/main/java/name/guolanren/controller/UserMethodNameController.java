package name.guolanren.controller;

import name.guolanren.repository.UserMethodNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/mn")
public class UserMethodNameController {

    @Autowired
    private UserMethodNameRepository userMethodNameRepository;

    @GetMapping("/findAll")
    public Object findAll() {
        return userMethodNameRepository.findAll();
    }

    @GetMapping("/findByName")
    public Object findByName(String name) {
        return userMethodNameRepository.findByName(name);
    }

    @GetMapping("/findByAge")
    public Object findByAge(Integer age) {
        return userMethodNameRepository.findByAge(age);
    }

    @GetMapping("/findByNameAndAge")
    public Object findByNameAndAge(String name, Integer age) {
        return userMethodNameRepository.findByNameAndAge(name, age);
    }

    @GetMapping("/findByNameOrAge")
    public Object findByNameOrAge(String name, Integer age) {
        return userMethodNameRepository.findByNameOrAge(name, age);
    }

}
