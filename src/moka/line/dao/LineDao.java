package moka.line.dao;

import moka.basic.dao.BasicDao;
import moka.comment.bo.CommentRelation;
import moka.line.bo.Line;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("lineDao")
public interface LineDao extends BasicDao<Line, LineTo> {
    LineTo findOneOfUser(LineVo lineVo);

    int addPraised(LineVo lineVo);

    int addReview(LineVo lineVo);

    int addForward(LineVo lineVo);
}
