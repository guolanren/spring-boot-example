package name.guolanren.service;

import com.github.pagehelper.PageInfo;
import name.guolanren.model.SysUser;
import name.guolanren.model.dto.SysUserDTO;
import name.guolanren.model.vo.SysUserVO;

/**
 * @author guolanren
 */
public interface SysUserService extends BaseService<SysUser, Long> {

    PageInfo<SysUserVO> findVO(SysUserDTO sysUserDTO, Integer pageNum, Integer pageSize);

}
