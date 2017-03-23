package moka.user.controller;

import com.alibaba.fastjson.JSONObject;
import moka.basic.page.Page;
import moka.user.bo.UserEntity;
import moka.user.service.UserDetailService;
import moka.user.service.UserService;
import moka.user.vo.User;
import moka.user.vo.UserDetail;
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
@RequestMapping(value = "/userDetail")
public class UserDetailController {
    @Resource
    private UserDetailService userDetailService;

    /**
     * 增
     * @param userDetail
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody UserDetail userDetail) {
        int a = userDetailService.insert(userDetail);
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "success");
        json.put("data", userDetail);
        return json;
    }

}
