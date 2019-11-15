package name.guolanren.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import name.guolanren.mapper.UserMapper;
import name.guolanren.model.User;
import name.guolanren.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author guolanren
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
