package moka.line.dao;

import moka.basic.dao.BasicDao;
import moka.line.bo.Line;
import moka.line.to.LineTo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("lineDao")
public interface LineDao extends BasicDao<Line, LineTo> {
    int addPraised(int id);

    int addReview(int id);

    int addForward(int id);
}
