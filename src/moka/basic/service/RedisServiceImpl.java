package moka.basic.service;

import com.alibaba.fastjson.JSON;
import moka.user.to.UserTo;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by moka on 2017/4/16 0016.
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    public static final String USER_LOGIN_SESSION = "USER_LOGIN_SESSION";

    @Resource(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "shardedJedisPool")
    public ShardedJedisPool shardedJedisPool;

    public RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public boolean addUserSession(Object o) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(USER_LOGIN_SESSION);
                byte[] value = serializer.serialize(JSON.toJSONString(o));
                Expiration expiration = Expiration.from(12, TimeUnit.HOURS);
                connection.set(key, value, expiration, RedisStringCommands.SetOption.UPSERT);
                return true;
            }
        });
    }

    @Override
    public UserTo getUserSession() {
        return redisTemplate.execute(new RedisCallback<UserTo>() {
            public UserTo doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(USER_LOGIN_SESSION);
                byte[] _user = connection.get(key);
                String u = serializer.deserialize(_user);
                return JSON.parseObject(u, UserTo.class);
            }
        });
    }

    @Override
    public boolean flashLoginSession() {
        return redisTemplate.hasKey(USER_LOGIN_SESSION) && redisTemplate.expire(USER_LOGIN_SESSION, 12, TimeUnit.HOURS);
    }
}
