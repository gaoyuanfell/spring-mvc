package moka.reply.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.reply.bo.Reply;
import moka.reply.dao.ReplyDao;
import moka.reply.to.ReplyTo;
import moka.reply.vo.ReplyVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("replyService")
public class ReplyServiceImpl extends BasicServiceImpl implements ReplyService {
    @Resource
    private ReplyDao replyDao;

    @Override
    public int insert(ReplyVo replyVo) {
        replyVo.setCreateDate(new Date());
        return replyDao.insert(this.convertBusinessValue(Reply.class, replyVo));
    }

    @Override
    public ReplyTo findOne(Integer id) {
        return null;
    }

    @Override
    public Page findPage(ReplyVo replyVo) {
        List list = null;
        if(replyVo.getCommentId() != 0){
            list = replyDao.findPage(replyVo);
        }
        int totalCount = replyDao.findCount();
        return new Page(totalCount,list);
    }

    @Override
    public List<ReplyTo> findList(ReplyVo replyVo) {
        return replyDao.findList(replyVo);
    }

    @Override
    public int addPraised(ReplyVo replyVo) {
        return 0;
    }

    @Override
    public int addReview(ReplyVo replyVo) {
        return 0;
    }
}
