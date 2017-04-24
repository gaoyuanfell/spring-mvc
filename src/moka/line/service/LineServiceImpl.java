package moka.line.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.comment.bo.CommentRelation;
import moka.comment.dao.CommentDao;
import moka.line.bo.Line;
import moka.line.dao.LineDao;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("lineService")
public class LineServiceImpl extends BasicServiceImpl implements LineService {
    @Resource
    private LineDao lineDao;
    @Resource
    private CommentDao commentDao;

    @Override
    public int insert(LineVo lineVo) {
        Line line = this.convertBusinessValue(lineVo, Line.class);
        line.setCreateDate(new Date());
        lineDao.insert(line);
        return line.getId();
    }

    @Override
    public LineTo findOne(Integer id) {
        return lineDao.findOne(id);
    }

    @Override
    public LineTo findOneOfUser(LineVo lineVo) {
        return lineDao.findOneOfUser(lineVo);
    }

    @Override
    public Page findPage(LineVo lineVo) {
        List<LineTo> list = lineDao.findPage(lineVo);
        int totalCount = lineDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public int addPraised(LineVo lineVo) {
        CommentRelation commentRelation =  new CommentRelation();
        commentRelation.setUserId(lineVo.getUserId());
        commentRelation.setLineId(lineVo.getId());
        commentRelation.setComType(1);
        commentRelation.setType(1);
        int i = commentDao.hasCommentRelation(commentRelation);
        if(i == 0){
            commentDao.insertCommentRelation(commentRelation);
        }else{
            lineVo.setOperationType(true);//按减法运算总赞数
            commentDao.removeCommentRelation(commentRelation);
        }
        return lineDao.addPraised(lineVo);
    }

    @Override
    public int addReview(LineVo lineVo) {
        return lineDao.addReview(lineVo);
    }

    @Override
    public int addForward(LineVo lineVo) {
        return lineDao.addForward(lineVo);
    }
}
