package moka.user.service;

import moka.basic.service.BasicService;
import moka.user.vo.UserDetailVo;

/**
 * Created by moka on 2017/3/23.
 */

public interface UserDetailService extends BasicService {
    int insert(UserDetailVo userDetail);
}
