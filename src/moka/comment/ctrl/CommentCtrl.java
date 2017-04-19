package moka.comment.ctrl;

import moka.basic.controller.BasicController;
import moka.basic.page.Page;
import moka.comment.service.CommentService;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;

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
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody CommentVo commentVo) {
        int i = commentService.insert(commentVo);
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
        CommentTo commentTo = commentService.findOne(id);
        return result(commentTo);
    }

    /**
     * 查 分页
     *
     * @return
     */
    @RequestMapping(value = "findPage.htm")
    @ResponseBody
    public Object findPage(@RequestBody CommentVo commentVo) {
        Page list = commentService.findPage(commentVo);
        String[] s = {"1", "2", "3", "4", "5"};
        System.out.println(s[5]);
        return result(list);
    }
}
