package moka.comment.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.comment.bo.Comment;
import moka.comment.dao.CommentDao;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("commentService")
public class CommentServiceImpl extends BasicServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    @Override
    public int insert(CommentVo commentVo) {
        Comment comment = this.convertBusinessValue(commentVo, Comment.class);
        commentDao.insert(comment);
        return comment.getId();
    }

    @Override
    public CommentTo findOne(Integer id) {
        return commentDao.findOne(id);
    }

    @Override
    public Page findPage(CommentVo commentVo) {
        List list = commentDao.findPage(commentVo);
        int totalCount = commentDao.findCount();
        return new Page(totalCount, list);
    }
}
