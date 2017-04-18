package moka.user.ctrl;

import com.alibaba.fastjson.JSON;
import moka.basic.annotation.IgnoreSecurity;
import moka.basic.annotation.NotAspect;
import moka.basic.bo.Token;
import moka.basic.controller.BasicController;
import moka.basic.log4j.LoggerService;
import moka.basic.page.Page;
import moka.user.bo.User;
import moka.user.service.UserService;
import moka.user.to.UserTo;
import moka.user.vo.UserVo;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        int n = userService.findRepeatUser(user.getUser());
        if(n > 0){
            return result(CODE_PROMPT, "用户名已存在！");
        }
        int i = userService.insert(user);
        return result(i);
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
    public Object findPage(@RequestBody UserVo user) {
        Page list = userService.findPage(user);
        return result(list);
    }

    /**
     * 登录
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "login.htm")
    @ResponseBody
    @IgnoreSecurity
    public Object login(@RequestBody UserVo userVo, HttpServletResponse response) {
        UserTo u = userService.login(userVo);
        boolean b = false;
        Token t = null;
        if (u != null) {
            t = new Token(u, Integer.toString(u.getId()));
            b = addUserSession(t);
//            UserTo userTo = getUserSession(t);
//            System.out.println(userTo);
        }
        if (b) {
            response.setHeader("X-Token", t.getToken());
            return result(u);
        } else {
            return result(CODE_PROMPT, "登录失败");
        }
    }

    /**
     * 退出
     * @param request
     * @param userVo
     * @return
     */
    @RequestMapping(value = "logout.htm")
    @ResponseBody
    @IgnoreSecurity
    public Object logout(HttpServletRequest request, @RequestBody UserVo userVo) {
        String token = request.getHeader("X-Token");
        Token t = new Token(userVo.getId(), token);
        boolean b = deleteLoginSession(t);
        if (b)
            return result();
        else
            return result(CODE_PROMPT, "注销登录失败");
    }
}
