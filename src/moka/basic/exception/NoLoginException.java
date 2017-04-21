package moka.basic.exception;

/**
 * 基础 没有登录异常
 * Created by moka on 2017/3/10 0010.
 */

public class NoLoginException extends RuntimeException {

    public NoLoginException() {
        super();
    }

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException(String message, Exception e) {
        super(message, e);
    }
}
