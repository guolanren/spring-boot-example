package name.guolanren.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import name.guolanren.mapper.UserMapper;
import name.guolanren.model.User;
import name.guolanren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guolanren
 */
@Service
@DS("slave")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DS("master")
    public Long insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    @DS("master")
    public Long delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    @DS("master")
    public Long update(User user) {
        return userMapper.update(user);
    }

    @Override
    @DS("slave_1")
    public User get(Long id) {
        return userMapper.get(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
