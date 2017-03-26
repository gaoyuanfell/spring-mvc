package moka.user.dao;

import moka.basic.dao.BasicDao;
import moka.user.bo.UserDetailEntity;
import moka.user.to.UserDetailTo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/3/23.
 */
@Repository("userDetailDao")
public interface UserDetailDao extends BasicDao<UserDetailEntity, UserDetailTo> {

}
