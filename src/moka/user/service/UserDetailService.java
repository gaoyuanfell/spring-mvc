package moka.user.service;

import moka.basic.service.BasicService;
import moka.user.vo.UserDetail;

/**
 * Created by moka on 2017/3/23.
 */

public interface UserDetailService extends BasicService {
    int insert(UserDetail userDetail);
}
