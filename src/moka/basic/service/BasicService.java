package moka.basic.service;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicService {
    public <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties);

    public <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties);
}
