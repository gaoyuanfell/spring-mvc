package moka.lineSend.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.comment.bo.CommentRelation;
import moka.comment.dao.CommentDao;
import moka.line.dao.LineDao;
import moka.line.vo.LineVo;
import moka.lineSend.bo.LineSend;
import moka.lineSend.dao.LineSendDao;
import moka.lineSend.to.LineSendTo;
import moka.lineSend.vo.LineSendVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("lineSendService")
public class LineSendServiceImpl extends BasicServiceImpl implements LineSendService {
    @Resource
    private LineDao lineDao;

    @Resource
    private LineSendDao lineSendDao;

    @Resource
    private CommentDao commentDao;

    @Override
    public int insert(LineSendVo lineSendVo) {
        LineSend lineSend = this.convertBusinessValue(lineSendVo, LineSend.class);
        lineSend.setCreateDate(new Date());
        lineSendDao.insert(lineSend);
        //转发成功后线路分享+
        LineVo lineVo = new LineVo();
        lineVo.setId(lineSendVo.getLineId());
        lineDao.addForward(lineVo);
        return lineSend.getId();
    }

    @Override
    public LineSendTo findOne(Integer id) {
        return lineSendDao.findOne(id);
    }

    @Override
    public LineSendTo findOneOfUser(LineSendVo lineSendVo) {
        return lineSendDao.findOneOfUser(lineSendVo);
    }

    @Override
    public Page findPage(LineSendVo lineSendVo) {
        List list = lineSendDao.findPage(lineSendVo);
        int totalCount = lineSendDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public int addPraised(LineSendVo lineSendVo) {
        CommentRelation commentRelation = new CommentRelation();
        commentRelation.setUserId(lineSendVo.getUserId());
        commentRelation.setLineId(lineSendVo.getId());
        commentRelation.setComType(1);
        int i = commentDao.hasCommentRelation(commentRelation);
        if (i == 0) {
            commentDao.insertCommentRelation(commentRelation);
        } else {
            lineSendVo.setOperationType(true);//按减法运算总赞数
            commentDao.removeCommentRelation(commentRelation);
        }
        return lineSendDao.addPraised(lineSendVo);
    }

    @Override
    public int addReview(LineSendVo lineSendVo) {
        return lineSendDao.addReview(lineSendVo);
    }

    @Override
    public int addForward(LineSendVo lineSendVo) {
        CommentRelation commentRelation = new CommentRelation();
        commentRelation.setUserId(lineSendVo.getUserId());
        commentRelation.setLineId(lineSendVo.getId());
        commentRelation.setComType(3);
        int i = commentDao.hasCommentRelation(commentRelation);
        if (i == 0) {
            commentDao.insertCommentRelation(commentRelation);
        } else {
            lineSendVo.setOperationType(true);//按减法运算总赞数
            commentDao.removeCommentRelation(commentRelation);
        }
        return lineSendDao.addForward(lineSendVo);
    }
}
