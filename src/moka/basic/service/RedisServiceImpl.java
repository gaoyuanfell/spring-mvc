package moka.basic.service;

import com.alibaba.fastjson.JSON;
import moka.basic.bo.Token;
import moka.user.bo.User;
import moka.user.to.UserTo;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by moka on 2017/4/16 0016.
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Resource(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate;

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
    public <T> T get(String k,Class c) {
        return redisTemplate.execute(new RedisCallback<T>() {
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(k);
                byte[] data = connection.get(key);
                String u = serializer.deserialize(data);
                try {
                    Object o = JSON.parseObject(u,c);
                    return (T) o;
                } catch (Exception e) {
                    return (T) u;
                }
            }
        });
    }

    @Override
    public boolean addUserSession(Token t) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key = serializer.serialize(t.getKey());
                byte[] token = serializer.serialize(t.getToken());
                byte[] value = serializer.serialize(JSON.toJSONString(t.getT()));
                Expiration expiration = Expiration.from(12, TimeUnit.HOURS);
                connection.set(key, token, expiration, RedisStringCommands.SetOption.UPSERT);
                connection.set(token, value, expiration, RedisStringCommands.SetOption.UPSERT);
                return true;
            }
        });
    }

    @Override
    public UserTo getUserSession(Token t) {
        if(StringUtils.isEmpty(t.getKey()) && !StringUtils.isEmpty(t.getToken())){
            return get(t.getToken(),UserTo.class);
        }else{
            String token = get(t.getKey(),String.class);
            return get(token,UserTo.class);
        }
    }

    @Override
    public boolean flashLoginSession(Token t) {
        UserTo u = get(t.getToken(),UserTo.class);
        if (u == null) return false;
        String key = Integer.toString(u.getId());
        return redisTemplate.expire(key, 12, TimeUnit.HOURS) && redisTemplate.expire(t.getToken(), 12, TimeUnit.HOURS);
    }

    @Override
    public boolean deleteLoginSession(Token t) {
        if(StringUtils.isEmpty(t.getKey()) || StringUtils.isEmpty(t.getToken())) return false;
        if(!(hasKey(t.getKey()) && hasKey(t.getToken()))) return false;
        delete(t.getKey());
        delete(t.getToken());
        return true;
    }
}
