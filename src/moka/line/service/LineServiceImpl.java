package moka.line.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
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
    public Page findPage(LineVo lineVo) {
        List list = lineDao.findPage(lineVo);
        int totalCount = lineDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public int addPraised(int id) {
        return lineDao.addPraised(id);
    }

    @Override
    public int addReview(int id) {
        return lineDao.addReview(id);
    }

    @Override
    public int addForward(int id) {
        return lineDao.addForward(id);
    }
}
