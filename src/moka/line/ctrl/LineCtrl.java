package moka.line.ctrl;

import moka.basic.ctrl.BasicController;
import moka.basic.page.Page;
import moka.line.service.LineService;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;
import moka.lineSend.service.LineSendService;
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
@RequestMapping(value = "/line")
public class LineCtrl extends BasicController {
    @Resource
    private LineService lineService;
    @Resource
    private LineSendService lineSendService;

    /**
     * 增
     *
     * @param lineVo
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody LineVo lineVo) {
        UserTo userTo = getUserSession();
        if (userTo != null) {
            lineVo.setUserId(userTo.getId());
            int i = lineService.insert(lineVo);
            return result(i);
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 查one
     *
     * @param lineVo
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(@RequestBody LineVo lineVo) {
        if (!StringUtils.isEmpty(lineVo.getId())) {
            LineTo lineTo = lineService.findOne(lineVo.getId());
            return result(lineTo);
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 查one 带有用户操作情况
     *
     * @param lineVo
     */
    @RequestMapping(value = "findOneOfUser.htm")
    @ResponseBody
    public Object findOneOfUser(@RequestBody LineVo lineVo) {
        int userId = getUserSessionId();
        if (lineVo.getId() != 0 && userId != 0) {
            lineVo.setUserId(userId);
            LineTo lineTo = lineService.findOneOfUser(lineVo);
            return result(lineTo);
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
    public Object findPage(@RequestBody LineVo lineVo) {
        UserTo userTo = getUserSession();
        lineVo.setUserId(userTo.getId());
        Page list = lineService.findPage(lineVo);
        return result(list);
    }

    /**
     * 点赞+
     * {
     * "id": 1
     * }
     */
    @RequestMapping(value = "addPraised.htm")
    @ResponseBody
    public Object addPraised(@RequestBody LineVo lineVo) {
        int userId = getUserSessionId();
        if (lineVo.getId() != 0 && userId != 0) {
            lineVo.setUserId(userId);
            int i = lineService.addPraised(lineVo);
            if (lineVo.isOperationType()) {
                return result(true);
            }
            return result();
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }

    /**
     * 线路删除
     * @param lineVo
     * {
     *     id:'1'
     * }
     * @return
     */
    @RequestMapping(value = "delete.htm")
    @ResponseBody
    public Object delete(@RequestBody LineVo lineVo) {
        int userId = getUserSessionId();
        if (lineVo.getId() != 0 && userId != 0) {
            lineVo.setUserId(userId);
            int i = lineService.delete(lineVo);
            return result(i);
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }

    }
}
