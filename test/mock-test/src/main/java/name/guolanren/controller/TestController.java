package name.guolanren.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
public class TestController {

    @GetMapping("/get/{id}")
    public Object get(@PathVariable("id") Long id) {
        return "get " + id;
    }

    @PostMapping("/post")
    public Object post(@RequestBody ObjectNode objectNode) {
        objectNode.put("method", "post");
        return objectNode;
    }

    @DeleteMapping("/delete")
    public Object delete(@RequestParam("id") Long id) {
        return "delete " + id;
    }

}
