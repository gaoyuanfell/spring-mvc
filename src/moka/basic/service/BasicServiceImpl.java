package moka.basic.service;

import moka.basic.exception.ConvertValueException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Service("BasicService")
public class BasicServiceImpl implements BasicService {

    @Resource(name = "redisTemplate")
    public RedisTemplate<String, String> redisTemplate;

    @Resource(name = "shardedJedisPool")
    public ShardedJedisPool shardedJedisPool;

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
