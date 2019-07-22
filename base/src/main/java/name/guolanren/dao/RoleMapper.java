package name.guolanren.dao;

import name.guolanren.model.Role;

import java.util.List;

/**
 * 用户角色 Mapper
 *
 * @author guolanren
 */
public interface RoleMapper extends BaseMapper<Role, Long> {

    List<Role> findRolesBySysUserId(Long sysUserId);

}
