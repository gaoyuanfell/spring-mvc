package moka.basic.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by moka on 2017/3/27 0027.
 */
public class BasicController {

    public static final Map<String, Object> SUCCESS = new HashMap<String, Object>() {{
        put("msg", "success");
        put("code", 200);
    }};

    public static final Map<String, Object> ERROR = new HashMap<String, Object>() {{
        put("msg", "error");
        put("code", 500);
    }};
}
