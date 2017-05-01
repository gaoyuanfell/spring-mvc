package moka.reply.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.comment.bo.CommentRelation;
import moka.comment.dao.CommentDao;
import moka.comment.service.CommentService;
import moka.comment.vo.CommentVo;
import moka.reply.bo.Reply;
import moka.reply.dao.ReplyDao;
import moka.reply.to.ReplyTo;
import moka.reply.vo.ReplyVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("replyService")
public class ReplyServiceImpl extends BasicServiceImpl implements ReplyService {
    @Resource
    private ReplyDao replyDao;
    @Resource
    private CommentService commentService;

    @Override
    public int insert(ReplyVo replyVo) {
        replyVo.setCreateDate(new Date());

        CommentVo commentVo = new CommentVo();
        commentVo.setId(replyVo.getCommentId());
        commentService.addReview(commentVo);

        return replyDao.insert(this.convertBusinessValue(Reply.class, replyVo));
    }

    @Override
    public ReplyTo findOne(Integer id) {
        return replyDao.findOne(id);
    }

    @Override
    public Page findPage(ReplyVo replyVo) {
        List list = replyDao.findPage(replyVo);
        int totalCount = replyDao.findCount();
        return new Page(totalCount,list);
    }
    @Override
    public Page findOfComPage(ReplyVo replyVo) {
        List list = null;
        if(replyVo.getCommentId() != 0){
            list = replyDao.findPage(replyVo);
        }
        int totalCount = replyDao.findCount();
        return new Page(totalCount,list);
    }

    @Override
    public List<ReplyTo> findList(ReplyVo replyVo) {
        return replyDao.findList(replyVo);
    }

    @Override
    public int addPraised(ReplyVo replyVo) {
        CommentRelation commentRelation =  new CommentRelation();
        commentRelation.setUserId(replyVo.getUserId());
        commentRelation.setReplyId(replyVo.getId());
        commentRelation.setLineSendId(replyVo.getLineSendId());
        commentRelation.setLineId(replyVo.getLineId());
        commentRelation.setComType(1);
        commentRelation.setType(4);
        int i = commentService.hasCommentRelation(commentRelation);
        //已经点过赞的总赞数-1 并移除关联
        if(i == 0){
            commentService.insertCommentRelation(commentRelation);
        }else{
            replyVo.setOperationType(true);//按减法运算总赞数
            commentService.removeCommentRelation(commentRelation);
        }
        return replyDao.addPraised(replyVo);
    }

    @Override
    public int addReview(ReplyVo replyVo) {
        return replyDao.addReview(replyVo);
    }
}
