package moka.basic.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * Created by moka on 2017/3/29 0029.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
//        logger.error("参数解析失败", e);
//        return new Response().failure("could_not_read_json");
        System.out.println(e);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        logger.error("不支持当前请求方法", e);
//        return new Response().failure("request_method_not_supported");
        System.out.println(e);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public void handleHttpMediaTypeNotSupportedException(Exception e) {
//        logger.error("不支持当前媒体类型", e);
//        return new Response().failure("content_type_not_supported");
        System.out.println(e);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
//        logger.error("服务运行异常", e);
//        return Response.failure(e.getMessage());
        System.out.println(e);
    }
}
