package moka.user.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.user.bo.UserEntity;
import moka.user.vo.User;

import java.util.List;

/**
 * Created by moka on 2017/3/5 0005.
 */

public interface UserService extends BasicService {
    int insert(User user);

    User findOne(Integer id);

    List<UserEntity> findList();

    Page<User> findPage(Page<User> page);
}
