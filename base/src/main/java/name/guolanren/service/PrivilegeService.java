package name.guolanren.service;

import name.guolanren.model.Privilege;

import java.util.List;

/**
 * @author guolanren
 */
public interface PrivilegeService extends BaseService<Privilege, Long> {

    /**
     * 根据角色id获取权限列表
     *
     * @param roleId 角色id
     * @return 对应权限列表
     */
    List<Privilege> getByRoleId(Long roleId);

}
