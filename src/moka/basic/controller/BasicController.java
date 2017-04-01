package moka.basic.controller;

import com.alibaba.fastjson.JSONObject;
import moka.basic.page.Page;

/**
 * Created by moka on 2017/3/27 0027.
 */
public class BasicController {
    public static Object result(Page page) {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        json.put("doc", page.getList());
        json.put("pageIndex", page.getPageIndex());
        json.put("pageSize", page.getPageSize());
        json.put("totalPage", page.getTotalPage());
        json.put("totalCount", page.getTotalCount());
        return json;
    }
    public static Object result(Object obj) {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        json.put("doc", obj);
        return json;
    }
    public static Object result(Object obj, int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        json.put("doc", obj);
        return json;
    }
    public static Object result(int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("code", code);
        return json;
    }
    public static Object result() {
        JSONObject json = new JSONObject();
        json.put("msg", "success");
        json.put("code", 200);
        return json;
    }
}
