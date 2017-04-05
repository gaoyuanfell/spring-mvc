package moka.user.controller;

import com.alibaba.fastjson.JSON;
import moka.basic.controller.BasicController;
import moka.basic.log4j.LoggerService;
import moka.basic.page.Page;
import moka.user.service.UserService;
import moka.user.to.UserTo;
import moka.user.vo.UserVo;
import org.slf4j.Logger;
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
public class UserController extends BasicController {

    @Resource
    private UserService userService;
    private Logger logger = LoggerService.getLogger(this.getClass());

    //test
    @RequestMapping(value = "hello.htm")
    @ResponseBody
    public String hello() {
        return "{message:hello world 你好！}";
    }

    //多动作控制器
    // @RequestBody application/json 接收参数
    @RequestMapping(params = "method=login")
    @ResponseBody
    public String login(@RequestBody UserVo user) {
        System.out.println(user.toString());
        return "{method:" + user.toString() + "}";
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
        return result();
    }

    //application/x-www-form-urlencoded 接收参数
    @RequestMapping(value = "user.htm")
    @ResponseBody
    public Object getUser(UserVo user) {
        return result();
    }


    /**
     * 增
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody UserVo user) {
        int i = userService.insert(user);
        return result(i);
    }

    /**
     * 增
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "save.htm")
    @ResponseBody
    public Object save(@RequestBody UserVo user) {
        int a = userService.insert(user);
        return result(a);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(int id) {
        UserTo user = userService.findOne(id);
        return result(user);
    }

    /**
     * 查 分页
     *
     * @return
     */
    @RequestMapping(value = "findPage.htm")
    @ResponseBody
    public Object findPage(Page page) {
        Page list = userService.findPage(page);
        logger.info(JSON.toJSONString(list));
        return result(list);
    }
}
