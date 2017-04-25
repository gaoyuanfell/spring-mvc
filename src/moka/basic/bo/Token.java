package moka.basic.bo;

import moka.basic.util.Util;

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
        this.token = Util.getTokenMd5();
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

}
