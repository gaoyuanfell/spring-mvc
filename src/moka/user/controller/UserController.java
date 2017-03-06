package moka.user.controller;

import com.alibaba.fastjson.JSONObject;
import moka.user.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Controller
@RequestMapping(value = "/user", produces = "text/html;charset=UTF-8")
public class UserController {
    //test
    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello() {
        return "{\"message\":\"hello world 你好！\"}";
    }

    //多动作控制器
    @RequestMapping(params = "method=login")
    @ResponseBody
    public String login(@RequestBody User user) {
        System.out.println(user.toString());
        return "{\"method\":\""+ user.toString() +"\"}";
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
        JSONObject json = new JSONObject();
        json.put("a",1);
        return json.toJSONString();
    }
}
