package moka.line.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;

/**
 * Created by moka on 2017/4/6 0006.
 */
public interface LineService extends BasicService {
    int insert(LineVo lineVo);

    LineTo findOne(Integer id);

    LineTo findOneOfUser(LineVo lineVo);

    Page findPage(LineVo lineVo);

    int addPraised(LineVo lineVo);

    int addReview(LineVo lineVo);

    int addForward(LineVo lineVo);

    int delete(LineVo lineVo);
}
