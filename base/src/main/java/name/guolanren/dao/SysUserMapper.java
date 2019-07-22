package name.guolanren.dao;

import com.github.pagehelper.Page;
import name.guolanren.model.SysUser;
import name.guolanren.model.dto.SysUserDTO;
import name.guolanren.model.vo.SysUserVO;

/**
 * 系统用户 Mapper
 *
 * @author guolanren
 */
public interface SysUserMapper extends BaseMapper<SysUser, Long>{

    Page<SysUserVO> findVO(SysUserDTO sysUserDTO);

}
