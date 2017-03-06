package moka.admin.controller;

import com.alibaba.fastjson.JSON;
import moka.admin.vo.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Controller
@RequestMapping(value = "/admin", produces = "text/html;charset=UTF-8")
public class HelloController {

    //test
    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello() {
        return "{\"message\":\"hello world 你好！\"}";
    }

    //多动作控制器
    @RequestMapping(params = "method=login")
    @ResponseBody
    public String login(@RequestBody Admin admin) {
        System.out.println(admin.toString());
        return "{\"method\":\""+ admin.toString() +"\"}";
    }

    //多动作控制器
    @RequestMapping(params = "method=logout")
    @ResponseBody
    public String logout() {
        return "{\"method\":\"logout\"}";
    }

    //方法名与 mapping值相同 .htm可以不写
    @RequestMapping(value = "path.htm")
    @ResponseBody
    public String getPath() {
        HashMap map = new HashMap<String, Object>();
        map.put('a', 1);
        return JSON.toJSONString(map);
    }
}
