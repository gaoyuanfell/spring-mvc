package moka.comment.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.comment.bo.Comment;
import moka.comment.bo.CommentRelation;
import moka.comment.dao.CommentDao;
import moka.comment.to.CommentTo;
import moka.comment.vo.CommentVo;
import moka.line.service.LineService;
import moka.line.vo.LineVo;
import moka.lineSend.service.LineSendService;
import moka.lineSend.vo.LineSendVo;
import moka.reply.service.ReplyService;
import moka.reply.to.ReplyTo;
import moka.reply.vo.ReplyVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("commentService")
public class CommentServiceImpl extends BasicServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;
    @Resource
    private LineService lineService;
    @Resource
    private LineSendService lineSendService;
    @Resource
    private ReplyService replyService;

    @Override
    public int insert(CommentVo commentVo) {
        Comment comment = this.convertBusinessValue(commentVo, Comment.class);
        comment.setCreateDate(new Date());
        commentDao.insert(comment);
        if(commentVo.getLineId() != 0){
            LineVo lineVo = new LineVo();
            lineVo.setId(commentVo.getLineId());
            lineService.addReview(lineVo);
        }
        if(commentVo.getLineSendId() != 0){
            LineSendVo lineSendVo = new LineSendVo();
            lineSendVo.setId(commentVo.getLineSendId());
            lineSendService.addReview(lineSendVo);
        }
        return comment.getId();
    }

    @Override
    public CommentTo findOne(Integer id) {
        return commentDao.findOne(id);
    }

    @Override
    public Page findPage(CommentVo commentVo) {
        List<CommentTo> list = commentDao.findPage(commentVo);
        int totalCount = commentDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public int addPraised(CommentVo commentVo) {
        CommentRelation commentRelation =  new CommentRelation();
        commentRelation.setUserId(commentVo.getUserId());
        commentRelation.setCommentId(commentVo.getId());
        commentRelation.setLineSendId(commentVo.getLineSendId());
        commentRelation.setLineId(commentVo.getLineId());
        commentRelation.setComType(1);
        commentRelation.setType(3);
        int i = commentDao.hasCommentRelation(commentRelation);
        //已经点过赞的总赞数-1 并移除关联
        if(i == 0){
            commentDao.insertCommentRelation(commentRelation);
        }else{
            commentVo.setOperationType(true);//按减法运算总赞数
            commentDao.removeCommentRelation(commentRelation);
        }
        return commentDao.addPraised(commentVo);
    }

    @Override
    public int addReview(CommentVo commentVo) {
        return commentDao.addReview(commentVo);
    }

    @Override
    public int addForward(CommentVo commentVo) {
        return commentDao.addForward(commentVo);
    }

    @Override
    public int insertCommentRelation(CommentRelation commentRelation) {
        return commentDao.insertCommentRelation(commentRelation);
    }

    @Override
    public int removeCommentRelation(CommentRelation commentRelation) {
        return commentDao.removeCommentRelation(commentRelation);
    }

    @Override
    public int hasCommentRelation(CommentRelation commentRelation) {
        return commentDao.hasCommentRelation(commentRelation);
    }
}
