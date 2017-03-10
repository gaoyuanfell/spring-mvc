package moka.basic.exception;

/**
 * 转换值异常
 * Created by moka on 2017/3/10 0010.
 */
public class ConvertValueException extends BusinessRuntimeException {

    public ConvertValueException(String message) {
        super(message);
    }

    public ConvertValueException(String message, Exception e) {
        super(message, e);
    }
}
