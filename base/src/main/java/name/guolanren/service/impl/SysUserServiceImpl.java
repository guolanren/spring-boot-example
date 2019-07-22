package name.guolanren.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import name.guolanren.dao.SysUserMapper;
import name.guolanren.model.SysUser;
import name.guolanren.model.dto.SysUserDTO;
import name.guolanren.model.vo.SysUserVO;
import name.guolanren.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Long> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<SysUserVO> findVO(SysUserDTO sysUserDTO, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(sysUserMapper.findVO(sysUserDTO));
    }

}
