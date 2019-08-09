package name.guolanren.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import name.guolanren.dao.SysUserMapper;
import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public PageInfo<SysUser> search(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.find());
    }
}
