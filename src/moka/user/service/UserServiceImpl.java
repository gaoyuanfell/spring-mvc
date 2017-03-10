package moka.user.service;

import moka.basic.service.BasicServiceImpl;
import moka.user.dao.UserDao;
import moka.user.vo.User;
import moka.user.bo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int insert(User user) {
        System.out.println(userDao);
        return userDao.insert(this.convertBusinessValue(user,UserEntity.class));
    }
}
