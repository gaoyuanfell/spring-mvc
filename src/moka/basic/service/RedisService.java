package moka.basic.service;

import moka.user.to.UserTo;

/**
 * Created by moka on 2017/4/16 0016.
 */
public interface RedisService {

    boolean addUserSession(Object o);

    boolean hasKey(String key);

    void delete(String key);

    UserTo getUserSession();

    Boolean flashLoginSession();

}
