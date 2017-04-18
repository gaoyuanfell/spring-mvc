package moka.basic.service;

import moka.basic.bo.Token;
import moka.user.to.UserTo;

/**
 * Created by moka on 2017/4/16 0016.
 */
public interface RedisService {

    boolean addUserSession(Token t);

    boolean hasKey(String key);

    <T> T get(String key,Class c);

    void delete(String key);

    UserTo getUserSession(Token t);

    boolean flashLoginSession(Token t);

    boolean deleteLoginSession(Token t);

}
