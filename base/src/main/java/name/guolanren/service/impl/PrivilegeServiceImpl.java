package name.guolanren.service.impl;

import name.guolanren.dao.PrivilegeMapper;
import name.guolanren.model.Privilege;
import name.guolanren.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guolanren
 */
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, Long> implements PrivilegeService {

    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> getByRoleId(Long roleId) {
        return privilegeMapper.findPrivilegesByRoleId(roleId);
    }

}
