package moka.user.dao;

import moka.basic.dao.BasicDaoImpl;
import moka.user.bo.User;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Repository("helloDao")
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao  {
    @Override
    public User findById(int id) throws Exception {
        return null;
    }

    @Override
    public int save(User o) throws Exception {
        return 0;
    }
}
