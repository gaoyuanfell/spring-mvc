package moka.basic.service;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicService {

    <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties);

    <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties);

}
