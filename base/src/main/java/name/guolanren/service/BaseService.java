package name.guolanren.service;

import java.util.List;

/**
 * @author guolanren
 */
public interface BaseService<T, ID extends Number> {

    /**
     * 添加资源
     *
     * @param t 持久化前的资源
     * @return 持久化后的资源
     */
    T create(T t);

    /**
     * 移除资源
     *
     * @param id 目标资源的id
     * @return 是否移除成功
     */
    Boolean remove(ID id);

    /**
     * 修改资源
     *
     * @param t 封装 需要修改的属性 的资源对象
     * @return 是否修改成功
     */
    Boolean modify(T t);

    /**
     * 获取实体(根据id)
     *
     * @param id 目标资源id
     * @return 对应资源
     */
    T getById(ID id);

    /**
     * 获取所有资源
     *
     * @return 资源列表
     */
    List<T> getAll();

    /**
     * 判断资源是否存在
     *
     * @param id 目标资源的id
     * @return 判断结果
     */
    Boolean exists(ID id);

}
