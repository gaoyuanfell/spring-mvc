package moka.lineSend.dao;

import moka.basic.dao.BasicDao;
import moka.lineSend.bo.LineSend;
import moka.lineSend.to.LineSendTo;
import moka.lineSend.vo.LineSendVo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("lineSendDao")
public interface LineSendDao extends BasicDao<LineSend, LineSendTo> {
    LineSendTo findOneOfUser(LineSendVo lineVo);

    int addPraised(LineSendVo lineVo);

    int addReview(LineSendVo lineVo);

    int addForward(LineSendVo lineVo);
}
