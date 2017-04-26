package moka.lineSend.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.comment.bo.CommentRelation;
import moka.comment.dao.CommentDao;
import moka.line.dao.LineDao;
import moka.line.to.LineTo;
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

        if(lineSendVo.getLineSendId() != 0){
            //从分支转发
            lineSendDao.addForward(lineSendVo);
        }

        int lineSendId = lineSendDao.insert(lineSend);

        //分享用户关联
        CommentRelation commentRelation = new CommentRelation();
        commentRelation.setUserId(lineSendVo.getUserId());
        commentRelation.setLineSendId(lineSend.getId());
        commentRelation.setType(2);
        commentRelation.setComType(3);
        commentDao.insertCommentRelation(commentRelation);

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
        LineSendTo lineSendTo = lineSendDao.findOneOfUser(lineSendVo);
        LineVo lineVo = new LineVo();
        lineVo.setUserId(lineSendVo.getUserId());
        lineVo.setId(lineSendTo.getLineId());
        LineTo lineTo = lineDao.findOneOfUser(lineVo);
        lineSendTo.setLine(lineTo);
        return lineSendTo;
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
        commentRelation.setLineSendId(lineSendVo.getId());
        commentRelation.setComType(1);
        commentRelation.setType(2);
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
    public int delete(LineSendVo lineSendVo) {
        LineVo lineVo = new LineVo();
        lineVo.setOperationType(true);
        lineVo.setId(lineSendVo.getLineId());
        lineDao.addForward(lineVo);
        return lineSendDao.delete(lineSendVo);
    }
}
