package moka.lineSend.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.lineSend.to.LineSendTo;
import moka.lineSend.vo.LineSendVo;

/**
 * Created by moka on 2017/4/6 0006.
 */
public interface LineSendService extends BasicService {
    int insert(LineSendVo lineSendVo);

    LineSendTo findOne(Integer id);

    LineSendTo findOneOfUser(LineSendVo lineSendVo);

    Page findPage(LineSendVo lineSendVo);

    int addPraised(LineSendVo lineSendVo);

    int addReview(LineSendVo lineSendVo);

    int addForward(LineSendVo lineSendVo);
}
