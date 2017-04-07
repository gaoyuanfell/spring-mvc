package moka.user.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.user.to.UserTo;
import moka.user.vo.UserVo;

/**
 * Created by moka on 2017/3/5 0005.
 */
public interface UserService extends BasicService {
    int insert(UserVo user);

    UserTo findOne(Integer id);

    Page findPage(UserVo userVo);
}
