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
@Api(value = "SysUser", tags = {"系统用户 模块"})
public class SysUserController {

    @ApiOperation(value = "CREATE", notes = "创建系统用户")
    @ApiImplicitParam(value = "系统用户", name = "sysUser", paramType = "body", dataType = "SysUser")
    @PostMapping
    public ResponseEntity create(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok("ok");
    }

    @ApiOperation(value = "REMOVE", notes = "移除系统用户")
    @ApiImplicitParam(value = "系统用户id", name = "id", paramType = "path", dataType = "Long", example = "1")
    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        return ResponseEntity.ok("ok");
    }

    @ApiOperation(value = "MODIFY", notes = "修改系统用户")
    @ApiImplicitParam(value = "系统用户", name = "sysUser", paramType = "body", dataType = "SysUser")
    @PutMapping
    public ResponseEntity modify(@RequestBody SysUser sysUser) {
        return ResponseEntity.ok("ok");
    }

    @ApiOperation(value = "GET_BY_ID", notes = "通过id获取系统用户")
    @ApiImplicitParam(value = "系统用户id", name = "id", paramType = "path", dataType = "Long", example = "1")
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setName("guolanren");
        return ResponseEntity.ok(sysUser);
    }

}
