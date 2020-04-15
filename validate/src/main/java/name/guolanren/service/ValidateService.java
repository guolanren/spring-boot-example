package name.guolanren.service;

import name.guolanren.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author guolanren
 */
@Service
@Validated
public class ValidateService {

    public void echo(@NotBlank(message = "name无效") String name) {
        System.out.println(name);
    }

    public void print(@Valid User user) {
        System.out.println(user);
    }

}
