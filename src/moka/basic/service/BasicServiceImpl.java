package moka.basic.service;

import moka.basic.exception.ConvertValueException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Service("BasicService")
public class BasicServiceImpl implements BasicService {
    @Override
    public <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties) {
        try {
            T t = target.newInstance();
            if (resource != null) {
                BeanUtils.copyProperties(resource, t, ignoreProperties);
            }
            return t;
        } catch (Exception e) {
            throw new ConvertValueException(e.getMessage(), e);
        }
    }

    @Override
    public <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties) {
        if (resource != null) {
            BeanUtils.copyProperties(resource, target, ignoreProperties);
        }
        return (T) target;
    }
}