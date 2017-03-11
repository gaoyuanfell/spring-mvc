package moka.user.controller;

import com.alibaba.fastjson.JSONObject;
import moka.user.bo.UserEntity;
import moka.user.service.UserService;
import moka.user.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UserService userService;

    /**
     * 增
     * @param user
     * @return
     */
    @RequestMapping(value = "insert")
    @ResponseBody
    public Object insert(@RequestBody User user) {
        int a = userService.insert(user);
        System.out.println(a);
        JSONObject json = new JSONObject();
        json.put("a",user);
        json.put("b",a);
        return json;
    }

    /**
     * 查
     * @param id
     * @return
     */
    @RequestMapping(value = "findOne")
    @ResponseBody
    public Object findOne(int id) {
        User user = userService.findOne(id);
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("msg","success");
        json.put("data",user);
        return json;
    }

    /**
     * 查 列表
     * @return
     */
    @RequestMapping(value = "findList")
    @ResponseBody
    public Object findList() {
        List<UserEntity> list = userService.findList();
        JSONObject json = new JSONObject();
        json.put("code",200);
        json.put("msg","success");
        json.put("data",list);
        return json;
    }
}
