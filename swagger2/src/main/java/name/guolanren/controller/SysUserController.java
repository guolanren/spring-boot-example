package name.guolanren.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import name.guolanren.model.SysUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/sys_user")
@Api(value = "SysUser", tags = {"系统用户"}, description = "系统用户 RESTful 接口")
public class SysUserController {

    /**
     * 创建系统用户
     */
    @ApiOperation(value = "创建系统用户", notes = "{\n" +
            "&nbsp;&nbsp;  name(系统用户名): 必填\n" +
            "}")
    @ApiImplicitParam(value = "系统用户", dataType = "SysUser", name = "sysUser", paramType = "body")
    @PostMapping
    public ResponseEntity create(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok("ok");
    }

    /**
     * 移除系统用户
     */
    @ApiOperation(value = "移除系统用户", notes = "移除系统用户")
    @ApiImplicitParam(value = "系统用户id", dataType = "Long", name = "id", paramType = "path", example = "1")
    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        return ResponseEntity.ok("ok");
    }

    /**
     * 修改系统用户
     */
    @ApiOperation(value = "修改系统用户", notes = "{\n" +
            "&nbsp;&nbsp;  id(系统用户 ID): 必填,\n" +
            "&nbsp;&nbsp;  name(系统用户名): 非必填\n" +
            "}")
    @ApiImplicitParam(value = "系统用户", dataType = "SysUser", name = "sysUser", paramType = "body")
    @PutMapping
    public ResponseEntity modify(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok("ok");
    }

    /**
     * 通过 ID 获取系统用户
     */
    @ApiOperation(value = "通过 ID 获取系统用户", notes = "通过 ID 获取系统用户")
    @ApiImplicitParam(value = "系统用户id", dataType = "Long", name = "id", paramType = "path", example = "1")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setName("guolanren");
        return ResponseEntity.ok(sysUser);
    }

}
