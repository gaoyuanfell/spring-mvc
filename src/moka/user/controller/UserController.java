package moka.user.controller;

import com.alibaba.fastjson.JSONObject;
import moka.user.service.UserService;
import moka.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    //test
    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello() {
        return "{message:hello world 你好！}";
    }

    //多动作控制器
    // @RequestBody application/json 接收参数
    @RequestMapping(params = "method=login")
    @ResponseBody
    public String login(@RequestBody User user) {
        System.out.println(user.toString());
        return "{method:"+ user.toString() +"}";
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
    public Object getPath() {
        JSONObject json = new JSONObject();
        json.put("a",1);
        return json;
    }

    //application/x-www-form-urlencoded 接收参数
    @RequestMapping(value = "user.htm")
    @ResponseBody
    public Object getUser(User user) {
        JSONObject json = new JSONObject();
        json.put("a",user);
        return json;
    }

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public Object insert(User user) {
        int a = userService.insert(user);
        System.out.println(a);
        JSONObject json = new JSONObject();
        json.put("a",user);
        json.put("b",a);
        return json;
    }
}
