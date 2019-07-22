package name.guolanren.service.impl;

import name.guolanren.dao.BaseMapper;
import name.guolanren.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author guolanren
 */
public abstract class BaseServiceImpl<T, ID extends Number> implements BaseService<T, ID> {

    @Autowired
    private BaseMapper<T, ID> baseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T create(T t) {
        baseMapper.insert(t);
        return t;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean remove(ID id) {
        Long removedRows = baseMapper.delete(id);
        return removedRows > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean modify(T t) {
        Long modifiedRows = baseMapper.update(t);
        return modifiedRows > 0;
    }

    @Override
    public T getById(ID id) {
        return baseMapper.findById(id);
    }

    @Override
    public List<T> getAll() {
        return baseMapper.getAll();
    }

    @Override
    public Boolean exists(ID id) {
        return baseMapper.exists(id);
    }

}
