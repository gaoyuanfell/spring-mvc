package moka.user.service;

import moka.basic.service.BasicService;
import moka.user.vo.User;

/**
 * Created by moka on 2017/3/5 0005.
 */

public interface UserService extends BasicService {
    int insert(User user);
}