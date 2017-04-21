package moka.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import moka.basic.bo.Token;
import moka.basic.service.RedisService;
import moka.user.to.UserTo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by moka on 2017/3/27 0027.
 */
public class BasicController {

    @Resource
    private RedisService redisService;

    @Value("#{propertyConfigurer['data_token_name']}")
    protected String tokenName;

    @Resource
    private HttpServletRequest request;

    protected static final int CODE_NO_LOGIN = 201;
    protected static final int CODE_PROMPT = 202;//提示

    protected static JSONObject result(Object obj) {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        json.put("doc", obj);
        return json;
    }

    protected static JSONObject result(Object obj, int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        json.put("doc", obj);
        return json;
    }

    protected static JSONObject result(int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        return json;
    }

    protected static JSONObject result() {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        return json;
    }

    protected boolean addUserSession(Token t) {
        return redisService.addUserSession(t);
    }

    protected UserTo getUserSession() {
        String token = request.getHeader("X-Token");
        if (StringUtils.isEmpty(token))
            return null;
        else
            return redisService.getUserSession(new Token(token));
    }

    protected boolean flashLoginSession(Token t) {
        return redisService.flashLoginSession(t);
    }

    protected boolean deleteLoginSession(Token t){
        return redisService.deleteLoginSession(t);
    }
}
