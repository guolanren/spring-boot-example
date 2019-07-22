package name.guolanren.controller;

import name.guolanren.common.ResultEntity;
import name.guolanren.exception.InvalidParamException;
import name.guolanren.model.Privilege;
import name.guolanren.model.validation.groups.CreateValidationGroup;
import name.guolanren.model.validation.groups.ModifyValidationGroup;
import name.guolanren.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/privileges")
public class PrivilegeController {

    @Autowired
    private PrivilegeService privilegeService;

    @PostMapping
    public ResultEntity create(@RequestBody @Validated(value = {CreateValidationGroup.class, Default.class}) Privilege privilege,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResultEntity.success(privilegeService.create(privilege));
    }

    @DeleteMapping("/{id:\\d+}")
    public ResultEntity remove(@PathVariable Long id) {
        if (id <= 0) {
            throw new InvalidParamException("id必须大于0");
        }
        privilegeService.remove(id);
        return ResultEntity.success();
    }

    @PutMapping
    public ResultEntity modify(@RequestBody @Validated(value = {ModifyValidationGroup.class, Default.class}) Privilege privilege,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        privilegeService.modify(privilege);
        return ResultEntity.success();
    }

    @GetMapping("/{id:\\d+}")
    public ResultEntity getById(@PathVariable Long id) {
        if (id <= 0) {
            throw new InvalidParamException("id必须大于0");
        }
        return ResultEntity.success(privilegeService.getById(id));
    }

}
