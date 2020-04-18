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
@DS("master")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Long delete(Long id) {
        return userMapper.delete(id);
    }

    @Override
    public Long update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User get(Long id) {
        return userMapper.get(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
