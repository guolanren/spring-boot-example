package name.guolanren.controller;

import name.guolanren.common.ResultEntity;
import name.guolanren.exception.InvalidParamException;
import name.guolanren.model.SysUser;
import name.guolanren.model.dto.SysUserDTO;
import name.guolanren.model.validation.groups.CreateValidationGroup;
import name.guolanren.model.validation.groups.GetValidationGroup;
import name.guolanren.model.validation.groups.ModifyValidationGroup;
import name.guolanren.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/sys_users")
@Validated
public class SysUserController {

    private static final Integer PAGE_NUM_MIN = 0;
    private static final Integer PAGE_SIZE_MIN = 1;
    private static final Integer PAGE_SIZE_MAX = 100;
    private static final Integer SYS_USER_ID_MIN = 1;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping
    public ResultEntity create(@RequestBody @Validated(value = {CreateValidationGroup.class, Default.class}) SysUser sysUser,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResultEntity.success(sysUserService.create(sysUser));
    }

    @DeleteMapping("/{id:\\d+}")
    public ResultEntity remove(@PathVariable Long id) {
        if (id < SYS_USER_ID_MIN) {
            throw new InvalidParamException(String.format("系统用户ID不能小于%s", SYS_USER_ID_MIN));
        }
        sysUserService.remove(id);
        return ResultEntity.success();
    }

    @PutMapping
    public ResultEntity modify(@RequestBody @Validated(value = {ModifyValidationGroup.class, Default.class}) SysUser sysUser,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        sysUserService.modify(sysUser);
        return ResultEntity.success();
    }

    @GetMapping("/{id:\\d+}")
    public ResultEntity getById(@PathVariable Long id) {
        if (id < SYS_USER_ID_MIN) {
            throw new InvalidParamException(String.format("系统用户ID不能小于%s", SYS_USER_ID_MIN));
        }
        return ResultEntity.success(sysUserService.getById(id));
    }

    @GetMapping
    public ResultEntity get(Integer pageNum, Integer pageSize,
                            @RequestBody @Validated(value = {GetValidationGroup.class, Default.class}) SysUserDTO sysUserDTO,
                            BindingResult bindingResult) {
        if (pageNum < PAGE_NUM_MIN) {
            throw new InvalidParamException(String.format("系统用户分页页码不能小于%s", PAGE_NUM_MIN));
        }
        if (pageSize < PAGE_SIZE_MIN || pageSize > PAGE_SIZE_MAX) {
            throw new InvalidParamException(String.format("系统用户分页页大小需要在%s和%s之间", PAGE_SIZE_MIN, PAGE_SIZE_MAX));
        }
        if (bindingResult.hasErrors()) {
            throw new InvalidParamException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResultEntity.success(sysUserService.findVO(sysUserDTO, pageNum, pageSize));
    }
}
