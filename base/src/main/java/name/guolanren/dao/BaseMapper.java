package name.guolanren.dao;

import java.util.List;

/**
 * 基础 Mapper
 *
 * @author guolanren
 */
public interface BaseMapper<T, ID extends Number> {

    Long insert(T t);

    Long delete(ID id);

    Long update(T t);

    T findById(ID id);

    List<T> getAll();

    Boolean exists(ID id);
}
