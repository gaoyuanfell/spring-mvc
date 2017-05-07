package moka.line.dao;

import moka.basic.dao.BasicDao;
import moka.line.bo.Line;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("lineDao")
public interface LineDao extends BasicDao<Line, LineTo> {

    List<LineTo> findPageAllDate(LineVo lineVo);

    LineTo findOneOfUser(LineVo lineVo);

    int addPraised(LineVo lineVo);

    int addReview(LineVo lineVo);

    int addForward(LineVo lineVo);
}
