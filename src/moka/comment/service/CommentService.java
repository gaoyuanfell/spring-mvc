package moka.comment.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;

/**
 * Created by moka on 2017/4/6 0006.
 */
public interface CommentService extends BasicService {
    int insert(CommentVo commentVo);

    CommentTo findOne(Integer id);

    Page findPage(CommentVo commentVo);
}