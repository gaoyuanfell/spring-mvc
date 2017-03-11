package moka.user.dao;

import moka.basic.dao.BasicDao;
import moka.user.bo.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Repository("userDao")
public interface UserDao extends BasicDao<UserEntity> {

}
