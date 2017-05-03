package moka.comment.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.comment.bo.CommentRelation;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;

/**
 * Created by moka on 2017/4/6 0006.
 */
public interface CommentService extends BasicService {
    int insert(CommentVo commentVo);

    CommentTo findOne(Integer id);

    Page findPage(CommentVo commentVo);

    int addPraised(CommentVo commentVo);

    int addReview(CommentVo commentVo);

    int addForward(CommentVo commentVo);

    int insertCommentRelation(CommentRelation commentRelation);

    int removeCommentRelation(CommentRelation commentRelation);

    int hasCommentRelation(CommentRelation commentRelation);
}
