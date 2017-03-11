package moka.user.service;

import moka.basic.service.BasicServiceImpl;
import moka.user.dao.UserDao;
import moka.user.vo.User;
import moka.user.bo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(this.convertBusinessValue(user,UserEntity.class));
    }

    @Override
    public User findOne(Integer id) {
        UserEntity userEntity = userDao.findOne(id);
        return this.convertBusinessValue(userEntity,User.class);
    }

    @Override
    public List<UserEntity> findList() {
        return userDao.findList();
    }
}
