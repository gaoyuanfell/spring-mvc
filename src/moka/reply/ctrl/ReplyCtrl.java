package moka.reply.ctrl;

import moka.basic.controller.BasicController;
import moka.basic.page.Page;
import moka.reply.service.ReplyService;
import moka.reply.to.ReplyTo;
import moka.reply.vo.ReplyVo;
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
@RequestMapping(value = "/reply")
public class ReplyCtrl extends BasicController {
    @Resource
    private ReplyService replyService;

    /**
     * 增
     *
     * @param replyVo 参数
     *                {
     *                "commentId":"1",
     *                "userToId":"2",
     *                "lineSendId":"1",
     *                "lineId":"1",
     *                "branchId":"1"
     *                }
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody ReplyVo replyVo) {
        int userId = getUserSessionId();
        replyVo.setUserId(userId);
        int i = replyService.insert(replyVo);
        return result(i);
    }

    /**
     * 查one
     *
     * @param replyVo
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(@RequestBody ReplyVo replyVo) {
        if (!StringUtils.isEmpty(replyVo.getId())) {
            ReplyTo replyTo = replyService.findOne(replyVo.getId());
            return result(replyTo);
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
    public Object findPage(@RequestBody ReplyVo replyVo) {
        UserTo userTo = getUserSession();
        replyVo.setUserId(userTo.getId());
        Page list = replyService.findPage(replyVo);
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
    public Object addPraised(@RequestBody ReplyVo replyVo) {
        UserTo userTo = getUserSession();
        if (replyVo.getId() != 0 && userTo != null && userTo.getId() != 0) {
            replyVo.setUserId(userTo.getId());
            int i = replyService.addPraised(replyVo);
            if (replyVo.isOperationType()) {
                return result(true);
            }
            return result();
        } else {
            return result(CODE_PROMPT, "id不能为空");
        }
    }
}
