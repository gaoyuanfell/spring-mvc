package moka.branch.service;

import moka.basic.page.Page;
import moka.basic.service.BasicServiceImpl;
import moka.branch.bo.Branch;
import moka.branch.dao.BranchDao;
import moka.branch.to.BranchTo;
import moka.branch.vo.BranchVo;
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

    @Override
    public int insert(BranchVo branchVo) {
        Branch branch = this.convertBusinessValue(branchVo, Branch.class);
        branch.setCreateDate(new Date());
        branchDao.insert(branch);
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
}
