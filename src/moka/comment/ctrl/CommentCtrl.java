package moka.comment.ctrl;

import moka.basic.ctrl.BasicController;
import moka.basic.page.Page;
import moka.comment.service.CommentService;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;
import moka.user.to.UserTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentCtrl extends BasicController {
    @Resource
    private CommentService commentService;

    /**
     * 增
     *
     * @param commentVo
     * @return 主线路参数 {
     * "context": "测试评论",
     * "lineId": "1",
     * "lineSendId": "1",
     * }
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody CommentVo commentVo) {
        int userId = getUserSessionId();
        if (userId != 0) {
            commentVo.setUserId(userId);
            int i = commentService.insert(commentVo);
            return result(i);
        } else {
            return result(CODE_PROMPT, "没有登录");
        }
    }

    /**
     * 查
     *
     * @param commentVo
     * @return
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(@RequestBody CommentVo commentVo) {
        if (commentVo.getId() != 0) {
            CommentTo commentTo = commentService.findOne(commentVo.getId());
            return result(commentTo);
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
    public Object findPage(@RequestBody CommentVo commentVo) {
        UserTo userTo = getUserSession();
        commentVo.setUserId(userTo.getId());
        Page list = commentService.findPage(commentVo);
        return result(list);
    }

    /**
     * 点赞+ 参数
     * {
     * "id": 1
     * }
     */
    @RequestMapping(value = "addPraised.htm")
    @ResponseBody
    public Object addPraised(@RequestBody CommentVo commentVo) {
        int userId = getUserSessionId();
        if (commentVo.getId() != 0 && userId != 0) {
            commentVo.setUserId(userId);
            int i = commentService.addPraised(commentVo);
            if (commentVo.isOperationType()) {
                return result(true);
            }
            return result();
        } else {
            return result(CODE_PROMPT, "id不能为空！");
        }
    }
}
