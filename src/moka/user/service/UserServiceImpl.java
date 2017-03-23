package moka.user.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.user.dao.UserDao;
import moka.user.vo.User;
import moka.user.bo.UserEntity;
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
        UserEntity userEntity = this.convertBusinessValue(user, UserEntity.class);
        userDao.insert(userEntity);
        return userEntity.getId();
    }

    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public List<UserEntity> findList() {
        return userDao.findList();
    }

    @Override
    public Page<User> findPage(Page<User> page) {
        List<User> list = userDao.findPage(page);
        int totalCount = userDao.findCount();
        page.setList(list);
        page.setTotalCount(totalCount);
        return page;
    }

    @Override
    public int save(User user) {
        return userDao.save(this.convertBusinessValue(user, UserEntity.class));
    }
}
