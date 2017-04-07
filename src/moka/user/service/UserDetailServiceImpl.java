package moka.user.service;

import moka.basic.service.BasicServiceImpl;
import moka.user.bo.UserDetail;
import moka.user.dao.UserDetailDao;
import moka.user.vo.UserDetailVo;
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
    public int insert(UserDetailVo userDetailVo) {
        UserDetail userDetail = this.convertBusinessValue(userDetailVo, UserDetail.class);
        userDetailDao.insert(userDetail);
        return userDetail.getId();
    }
}
