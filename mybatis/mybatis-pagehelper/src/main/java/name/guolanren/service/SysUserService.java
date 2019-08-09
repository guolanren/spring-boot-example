package name.guolanren.service;


import com.github.pagehelper.PageInfo;
import name.guolanren.model.SysUser;

/**
 * @author guolanren
 */
public interface SysUserService {

    PageInfo<SysUser> search(Integer pageNum, Integer pageSize);

}
