package name.guolanren.service;

import com.leayun.bdc.model.SysUser;

/**
 * 系统用户 Service
 *
 * @author 郭耀展
 */
public interface SysUserService {

    /**
     * 添加资源
     *
     * @param sysUser 持久化前的资源
     * @return 持久化后的资源
     */
    SysUser create(SysUser sysUser);

    /**
     * 移除资源
     *
     * @param id 目标资源的id
     * @return 是否移除成功
     */
    Boolean remove(Long id);

    /**
     * 修改资源
     *
     * @param sysUser 封装 需要修改的属性 的资源对象
     * @return 是否修改成功
     */
    Boolean modify(SysUser sysUser);

    /**
     * 获取实体(根据id)
     *
     * @param id 目标资源id
     * @return 对应资源
     */
    SysUser getById(Long id);
}
