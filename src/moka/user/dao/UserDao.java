package moka.user.dao;

import moka.basic.dao.BasicDao;
import moka.user.bo.User;
import moka.user.to.UserTo;
import moka.user.vo.UserVo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Repository("userDao")
public interface UserDao extends BasicDao<User, UserTo> {
    UserTo login(UserVo userVo);
}
