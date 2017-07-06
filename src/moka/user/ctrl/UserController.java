package moka.user.ctrl;

import moka.basic.annotation.IgnoreSecurity;
import moka.basic.bo.Token;
import moka.basic.ctrl.BasicController;
import moka.basic.log4j.LoggerService;
import moka.basic.page.Page;
import moka.user.service.UserService;
import moka.user.to.UserTo;
import moka.user.vo.UserVo;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BasicController {

    @Resource
    private UserService userService;
    private Logger logger = LoggerService.getLogger(this.getClass());

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
        }
        if (b) {
            response.setHeader("X-Token", t.getToken());
            return result(u);
        } else {
            return result(CODE_PROMPT, "登录失败");
        }
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
     * 查 所有
     *
     * @return
     */
    @RequestMapping(value = "findList.htm")
    @ResponseBody
    public Object findList(@RequestBody UserVo user) {
        List list = userService.findList(user);
        return result(list);
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
     * 退出
     * @param request
     * @return
     */
    @RequestMapping(value = "logout.htm",method = RequestMethod.GET)
    @ResponseBody
    @IgnoreSecurity
    public Object logout(HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        Token t = new Token(token);
        boolean b = deleteLoginSession(t);
        if (b)
            return result();
        else
            return result(CODE_PROMPT, "注销登录失败");
    }
}
