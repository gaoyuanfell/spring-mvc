package moka.comment.dao;

import moka.basic.dao.BasicDao;
import moka.comment.bo.Comment;
import moka.comment.to.CommentTo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("commentDao")
public interface CommentDao extends BasicDao<Comment, CommentTo> {

}
