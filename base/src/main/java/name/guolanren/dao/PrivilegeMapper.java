package name.guolanren.dao;

import name.guolanren.model.Privilege;

import java.util.List;

/**
 * 系统权限 Mapper
 *
 * @author guolanren
 */
public interface PrivilegeMapper extends BaseMapper<Privilege, Long> {

    List<Privilege> findPrivilegesByRoleId(Long roleId);

}
