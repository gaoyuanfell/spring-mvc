package moka.user.service;

import moka.basic.service.BasicServiceImpl;
import moka.user.bo.UserDetailEntity;
import moka.user.dao.UserDetailDao;
import moka.user.vo.UserDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/3/23.
 */
@Service("userDetailService")
public class UserDetailServiceImpl extends BasicServiceImpl implements UserDetailService {

    @Resource
    private UserDetailDao userDetailDao;

    @Override
    public int insert(UserDetail userDetail) {
        UserDetailEntity userDetailEntity = this.convertBusinessValue(userDetail, UserDetailEntity.class);
        userDetailDao.insert(userDetailEntity);
        return userDetailEntity.getId();
    }
}
