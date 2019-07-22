package name.guolanren.service.impl;

import name.guolanren.dao.RoleMapper;
import name.guolanren.model.Role;
import name.guolanren.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guolanren
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getBySystemUserId(Long systemUserId) {
        return roleMapper.findRolesBySysUserId(systemUserId);
    }
}
