package moka.user.ctrl;

import moka.basic.controller.BasicController;
import moka.user.service.UserDetailService;
import moka.user.vo.UserDetailVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/3/5 0005.
 */
@Controller
@RequestMapping(value = "/userDetail")
public class UserDetailController extends BasicController {
    @Resource
    private UserDetailService userDetailService;

    /**
     * 增
     *
     * @param userDetail
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody UserDetailVo userDetail) {
        int a = userDetailService.insert(userDetail);
        return result(a);
    }

}
