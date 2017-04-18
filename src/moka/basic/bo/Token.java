package moka.basic.bo;

import moka.basic.exception.BusinessRuntimeException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by moka on 2017/4/18 0018.
 */
public class Token {

    public Token(String token) {
        this.token = token;
    }

    public Token(int key,String token) {
        this.key = Integer.toString(key);
        this.token = token;
    }

    public Token(Object t, String key) {
        this.t = t;
        this.key = key;
        this.token = getTokenMd5();
    }

    private String token;
    private String key;
    private Object t;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getT() {
        return t;
    }

    public void setT(Object t) {
        this.t = t;
    }

    private String getTokenMd5() {
        BigDecimal time = BigDecimal.valueOf(System.currentTimeMillis());
        BigDecimal random = BigDecimal.valueOf(Math.floor(Math.random() * 1000));
        BigDecimal t = time.add(random);
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(t.toString().getBytes());
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (Exception e) {
            throw new BusinessRuntimeException(e.getMessage(), e);
        }
    }
}
