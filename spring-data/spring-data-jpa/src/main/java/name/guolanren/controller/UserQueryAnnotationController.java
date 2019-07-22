package name.guolanren.controller;

import name.guolanren.repository.UserQueryAnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/qa")
public class UserQueryAnnotationController {

    @Autowired
    private UserQueryAnnotationRepository userQueryAnnotationRepository;

    @GetMapping("/findAllByName")
    public Object findAllByName(String name) {
        return userQueryAnnotationRepository.findAllByName(name);
    }

    @GetMapping("/findAllByNameNative")
    public Object findAllByNameNative(String name) {
        return userQueryAnnotationRepository.findAllByNameNative(name);
    }

    @GetMapping("/findAllByNameStartsWith")
    public Object findAllByNameStartsWith(String name) {
        return userQueryAnnotationRepository.findAllByNameStartsWith(name);
    }

    @GetMapping("/findAllAndOrder")
    public Object findAllAndOrder() {
        return userQueryAnnotationRepository.findAllAndOrder(Sort.by(Sort.Order.asc("age")));
    }

    @GetMapping("/findAllAndOrderNative")
    public Object findAllAndOrderNative(Integer page, Integer size) {
        return userQueryAnnotationRepository.findAllAndOrderNative(PageRequest.of(page, size, Sort.by(Sort.Order.asc("age"))));
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return userQueryAnnotationRepository.findAll();
    }

    @PutMapping("/update")
    @Transactional
    public Object update(Long id, String name) {
        userQueryAnnotationRepository.update(id, name);
        return "finish";
    }
}
