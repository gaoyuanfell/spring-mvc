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
     * @return 从主线路转发
     * {
     * "lineId": "2", 为主线路id 必须
     * "lineSendId": "1" 支线id 有就传,
     * "sort": 1 排序 有就传,
     * "context": "测试内容"
     * }
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody LineSendVo lineSendVo) {
        int userId = getUserSessionId();
        if (userId != 0) {
            lineSendVo.setUserId(userId);
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
        int userId = getUserSessionId();
        if (lineSendVo.getId() != 0 && userId != 0) {
            lineSendVo.setUserId(userId);
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
        int userId = getUserSessionId();
        lineSendVo.setUserId(userId);
        if (userId != 0) {
            Page list = lineSendService.findPage(lineSendVo);
            return result(list);
        }else{
            return result(CODE_PROMPT, "没有登录");
        }
    }

    /**
     * 点赞+
     * {
     * "id": 1
     * }
     */
    @RequestMapping(value = "addPraised.htm")
    @ResponseBody
    public Object addPraised(@RequestBody LineSendVo lineSendVo) {
        int userId = getUserSessionId();
        if (lineSendVo.getId() != 0 && userId != 0) {
            lineSendVo.setUserId(userId);
            int i = lineSendService.addPraised(lineSendVo);
            if (!lineSendVo.isOperationType()) {
                return result();
            }
            return result(true);
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 转发删除
     * {
     *     id:"1
     * }
     * @param lineSendVo
     * @return
     */
    @RequestMapping(value = "delete.htm")
    @ResponseBody
    public Object delete(@RequestBody LineSendVo lineSendVo){
        int userId = getUserSessionId();
        lineSendVo.setUserId(userId);
        int i = lineSendService.delete(lineSendVo);
        return result(i);
    }
}
