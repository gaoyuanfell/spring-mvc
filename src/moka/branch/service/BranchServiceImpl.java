package moka.branch.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.branch.bo.Branch;
import moka.branch.dao.BranchDao;
import moka.branch.to.BranchTo;
import moka.branch.vo.BranchVo;
import moka.comment.bo.CommentRelation;
import moka.comment.dao.CommentDao;
import moka.comment.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Service("branchService")
public class BranchServiceImpl extends BasicServiceImpl implements BranchService {
    @Resource
    private BranchDao branchDao;
    @Resource
    private CommentDao commentDao;

    @Override
    public int insert(BranchVo branchVo) {
        Branch branch = this.convertBusinessValue(branchVo, Branch.class);
        branch.setCreateDate(new Date());
        branchDao.insert(branch);
        //将临时图片移动到对应路径
        this.movePhoto(branchVo.getUrls());
        return branch.getId();
    }

    @Override
    public BranchTo findOne(Integer id) {
        return branchDao.findOne(id);
    }

    @Override
    public Page findPage(BranchVo branchVo) {
        List list = branchDao.findPage(branchVo);
        int totalCount = branchDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public Page findPageOfLine(BranchVo branchVo) {
        List list = null;
        if(branchVo.getLineId() != 0){
            list = branchDao.findPageOfLine(branchVo);
        }
        int totalCount = branchDao.findCount();
        return new Page(totalCount, list);
    }

    @Override
    public int addPraised(BranchVo branchVo) {
        CommentRelation commentRelation = new CommentRelation();
        commentRelation.setUserId(branchVo.getUserId());
        commentRelation.setBranchId(branchVo.getId());
        commentRelation.setComType(1);
        commentRelation.setType(5);
        int i = commentDao.hasCommentRelation(commentRelation);
        if (i == 0) {
            commentDao.insertCommentRelation(commentRelation);
        } else {
            branchVo.setOperationType(true);//按减法运算总赞数
            commentDao.removeCommentRelation(commentRelation);
        }
        return branchDao.addPraised(branchVo);
    }

    @Override
    public int addReview(BranchVo branchVo) {
        return branchDao.addReview(branchVo);
    }
}
