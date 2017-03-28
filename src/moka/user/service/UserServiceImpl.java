package moka.user.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.user.bo.UserDetailEntity;
import moka.user.dao.UserDao;
import moka.user.dao.UserDetailDao;
import moka.user.to.UserTo;
import moka.user.bo.UserEntity;
import moka.user.vo.UserVo;
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

    @Resource
    private UserDetailDao userDetailDao;

    @Override
    public int insert(UserVo userVo) {
        UserDetailEntity userDetailEntity = this.convertBusinessValue(userVo.getUserDetail(), UserDetailEntity.class);
        userDetailDao.insert(userDetailEntity);
        UserEntity userEntity = this.convertBusinessValue(userVo, UserEntity.class);
        userEntity.setUserDetailId(userDetailEntity.getId());
        userDao.insert(userEntity);
        return userEntity.getId();
    }

    @Override
    public UserTo findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public Page findPage(Page page) {
        List list = userDao.findPage(page);
        int totalCount = userDao.findCount();
        page.setList(list);
        page.setTotalCount(totalCount);
        System.out.println(this.redisTemplate.hasKey("test"));
        if(this.redisTemplate.hasKey("test")){
            this.redisTemplate.delete("test");
        }
        this.redisTemplate.opsForSet().add("test","test");
        System.out.println(this.redisTemplate.opsForValue().get("test"));
        System.out.println(this.redisTemplate);
        return page;
    }
}
