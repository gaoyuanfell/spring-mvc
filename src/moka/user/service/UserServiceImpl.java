package moka.user.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.user.bo.UserDetail;
import moka.user.dao.UserDao;
import moka.user.dao.UserDetailDao;
import moka.user.to.UserTo;
import moka.user.bo.User;
import moka.user.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Service("userService")
public class UserServiceImpl extends BasicServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserDetailDao userDetailDao;

    @Override
    public int insert(UserVo userVo) {
        UserDetail userDetail = this.convertBusinessValue(userVo.getUserDetail(), UserDetail.class);
        userDetailDao.insert(userDetail);
        User user = this.convertBusinessValue(userVo, User.class);
        user.setUserDetailId(userDetail.getId());
        userDao.insert(user);
        return user.getId();
    }

    @Override
    public UserTo findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public Page findPage(UserVo userVo) {
        List list = userDao.findPage(userVo);
        int totalCount = userDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public List findList(UserVo userVo) {
        return userDao.findList(userVo);
    }

    @Override
    public UserTo login(UserVo userVo) {
        return userDao.login(userVo);
    }

    @Override
    public int findRepeatUser(String user) {
        return userDao.findRepeatUser(user);
    }
}
