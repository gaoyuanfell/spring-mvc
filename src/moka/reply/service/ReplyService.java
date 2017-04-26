package moka.reply.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.reply.to.ReplyTo;
import moka.reply.vo.ReplyVo;

/**
 * Created by moka on 2017/4/6 0006.
 */
public interface ReplyService extends BasicService {
    int insert(ReplyVo replyVo);

    ReplyTo findOne(Integer id);

    Page findPage(ReplyVo replyVo);

    int addPraised(ReplyVo replyVo);

    int addReview(ReplyVo replyVo);
}
