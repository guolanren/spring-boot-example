package name.guolanren.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import name.guolanren.mapper.SysUserMapper;
import name.guolanren.model.SysUser;
import name.guolanren.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
