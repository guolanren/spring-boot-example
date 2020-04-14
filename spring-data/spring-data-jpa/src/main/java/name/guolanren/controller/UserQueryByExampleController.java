package name.guolanren.controller;

import name.guolanren.model.User;
import name.guolanren.repository.UserQueryByExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/qbe")
public class UserQueryByExampleController {

    @Autowired
    private UserQueryByExampleRepository userQueryByExampleRepository;

    @GetMapping("/findAllByName")
    public Object findAllByName(@RequestParam String name, @RequestParam String nickName, @RequestParam Integer age) {
        User user = new User();
        user.setName(name);
        user.setNickName(nickName);
        user.setAge(age);
        Example<User> example = Example.of(user,
                ExampleMatcher.matchingAll()
                        .withIgnoreCase(false)
                        .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                        .withMatcher("nickName", ExampleMatcher.GenericPropertyMatchers.exact())
                        .withMatcher("age", ExampleMatcher.GenericPropertyMatchers.exact()));
        return userQueryByExampleRepository.findAll(example);
    }

}
