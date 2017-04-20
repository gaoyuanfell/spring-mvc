package moka.comment.dao;

import moka.basic.dao.BasicDao;
import moka.comment.bo.Comment;
import moka.comment.bo.CommentRelation;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("commentDao")
public interface CommentDao extends BasicDao<Comment, CommentTo> {

    int addPraised(CommentVo commentVo);

    int addReview(CommentVo commentVo);

    int addForward(CommentVo commentVo);

    int insertCommentRelation(CommentRelation commentRelation);

    int removeCommentRelation(CommentRelation commentRelation);

    int hasCommentRelation(CommentRelation commentRelation);
}
