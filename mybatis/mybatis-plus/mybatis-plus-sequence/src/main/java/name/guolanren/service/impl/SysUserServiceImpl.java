package name.guolanren.service.impl;

import com.leayun.bdc.dao.SysUserMapper;
import com.leayun.bdc.model.SysUser;
import com.leayun.bdc.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统用户 ServiceImpl
 *
 * @author 郭耀展
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser create(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
        return sysUser;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean remove(Long id) {
        Long removedRows = sysUserMapper.delete(id);
        return removedRows > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean modify(SysUser sysUser) {
        Long modifiedRows = sysUserMapper.update(sysUser);
        return modifiedRows > 0;
    }

    @Override
    public SysUser getById(Long id) {
        return sysUserMapper.findById(id);
    }
}
