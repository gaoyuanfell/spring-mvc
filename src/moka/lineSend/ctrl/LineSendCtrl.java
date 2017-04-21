package moka.lineSend.ctrl;

import moka.basic.controller.BasicController;
import moka.basic.page.Page;
import moka.lineSend.service.LineSendService;
import moka.lineSend.to.LineSendTo;
import moka.lineSend.vo.LineSendVo;
import moka.user.to.UserTo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Controller
@RequestMapping(value = "/lineSend")
public class LineSendCtrl extends BasicController {
    @Resource
    private LineSendService lineSendService;

    /**
     * 增
     *
     * @param lineSendVo
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody LineSendVo lineSendVo) {
        UserTo userTo = getUserSession();
        if (userTo != null) {
            lineSendVo.setUserId(userTo.getId());
            int i = lineSendService.insert(lineSendVo);
            return result(i);
        } else {
            return result(CODE_PROMPT, "没有登录");
        }
    }

    /**
     * 查one
     *
     * @param lineSendVo
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(@RequestBody LineSendVo lineSendVo) {
        if (!StringUtils.isEmpty(lineSendVo.getId())) {
            LineSendTo lineSendTo = lineSendService.findOne(lineSendVo.getId());
            return result(lineSendTo);
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 查one 带有用户操作情况
     *
     * @param lineSendVo
     */
    @RequestMapping(value = "findOneOfUser.htm")
    @ResponseBody
    public Object findOneOfUser(@RequestBody LineSendVo lineSendVo) {
        UserTo userTo = getUserSession();
        if (lineSendVo.getId() != 0 && userTo != null && userTo.getId() != 0) {
            lineSendVo.setUserId(userTo.getId());
            LineSendTo lineSendTo = lineSendService.findOneOfUser(lineSendVo);
            return result(lineSendTo);
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 查 分页
     *
     * @return
     */
    @RequestMapping(value = "findPage.htm")
    @ResponseBody
    public Object findPage(@RequestBody LineSendVo lineSendVo) {
        UserTo userTo = getUserSession();
        lineSendVo.setUserId(userTo.getId());
        Page list = lineSendService.findPage(lineSendVo);
        return result(list);
    }

    /**
     * 点赞+
     */
    @RequestMapping(value = "addPraised.htm")
    @ResponseBody
    public Object addPraised(@RequestBody LineSendVo lineSendVo) {
        UserTo userTo = getUserSession();
        if (lineSendVo.getId() != 0 && userTo != null && userTo.getId() != 0) {
            lineSendVo.setUserId(userTo.getId());
            int i = lineSendService.addPraised(lineSendVo);
            if (lineSendVo.isOperationType()) {
                return result(true);
            }
            return result();
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 评论+
     */
    @RequestMapping(value = "addReview.htm")
    @ResponseBody
    public Object addReview(@RequestBody LineSendVo lineSendVo) {
        if (lineSendVo.getId() != 0) {
            int i = lineSendService.addReview(lineSendVo);
            return result();
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 分享+
     */
    @RequestMapping(value = "addForward.htm")
    @ResponseBody
    public Object addForward(@RequestBody LineSendVo lineSendVo) {
        UserTo userTo = getUserSession();
        if (lineSendVo.getId() != 0 && userTo != null && userTo.getId() != 0) {
            lineSendVo.setUserId(userTo.getId());
            int i = lineSendService.addForward(lineSendVo);
            if (lineSendVo.isOperationType()) {
                return result(true);
            }
            return result();
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }
}
