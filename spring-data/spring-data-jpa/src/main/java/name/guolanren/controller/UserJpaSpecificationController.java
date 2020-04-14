package name.guolanren.controller;

import name.guolanren.model.specification.UserParam;
import name.guolanren.repository.UserJpaSpecificationRepository;
import name.guolanren.specification.factory.SpecificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/js")
public class UserJpaSpecificationController {

    @Autowired
    private UserJpaSpecificationRepository userJpaSpecificationRepository;

    @GetMapping("/findAllCondition")
    public Object findAllByFactory(@RequestBody UserParam userParam) {
        Specification specification = SpecificationFactory.nullSpecification();

        if (userParam.getId() != null) {
            specification = specification.and(SpecificationFactory.equals("id", userParam.getId()));
        }
        if (userParam.getName() != null) {
            specification = specification.and(SpecificationFactory.equals("name", userParam.getName()));
        }
        if (userParam.getBeginCreateTime() != null && userParam.getEndCreateTime() != null) {
            specification = specification.and(
                    SpecificationFactory.between("createTime", userParam.getBeginCreateTime(), userParam.getEndCreateTime()));
        }

        return userJpaSpecificationRepository.findAll(specification);
    }

}
