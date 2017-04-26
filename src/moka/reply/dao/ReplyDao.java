package moka.reply.dao;

import moka.basic.dao.BasicDao;
import moka.reply.bo.Reply;
import moka.reply.to.ReplyTo;
import moka.reply.vo.ReplyVo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("replyDao")
public interface ReplyDao extends BasicDao<Reply, ReplyTo> {
    ReplyTo findOneOfUser(ReplyVo replyVo);

    int addPraised(ReplyVo replyVo);

    int addReview(ReplyVo replyVo);

    int addForward(ReplyVo replyVo);
}
