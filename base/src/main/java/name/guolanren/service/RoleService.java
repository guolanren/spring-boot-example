package name.guolanren.service;

import name.guolanren.model.Role;

import java.util.List;

/**
 * @author guolanren
 */
public interface RoleService extends BaseService<Role, Long> {

    /**
     * 根据系统用户id获取角色列表
     *
     * @param systemUserId 系统用户id
     * @return 相应角色列表
     */
    List<Role> getBySystemUserId(Long systemUserId);

}
