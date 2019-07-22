package name.guolanren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author guolanren
 */
@Controller
public class JspWarController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
