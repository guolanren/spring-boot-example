package name.guolanren.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
// CORS方式二
@CrossOrigin(origins = {"http://localhost:8080", "null"}, allowCredentials = "true", maxAge = 3600)
public class CorsController {

    // CORS方式一
    @CrossOrigin(origins = {"http://localhost:8080", "null"})
    @GetMapping("/hi")
    public Object hi(String name) {
        return "hi " + name;
    }

}
