package moka.basic.controller;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by moka on 2017/3/27 0027.
 */
public class BasicController {
    public static JSONObject result(Object obj) {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        json.put("doc", obj);
        return json;
    }
    public static JSONObject result(Object obj, int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        json.put("doc", obj);
        return json;
    }
    public static JSONObject result(int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        return json;
    }
    public static JSONObject result() {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        return json;
    }
}
