package moka.basic.exception;

/**
 * 基础runtime exception
 * Created by moka on 2017/3/10 0010.
 */

public class BusinessRuntimeException extends RuntimeException {

    public BusinessRuntimeException() {
        super();
    }

    public BusinessRuntimeException(String message) {
        super(message);
    }

    public BusinessRuntimeException(String message, Exception e) {
        super(message, e);
    }
}
