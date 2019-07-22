package name.guolanren.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import name.guolanren.model.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author guolanren
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> findPageXmlCustomize(Page page, @Param("name") String name);

}
