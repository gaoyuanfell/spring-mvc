package moka.branch.service;

import moka.basic.page.Page;
import moka.basic.service.BasicService;
import moka.branch.to.BranchTo;
import moka.branch.vo.BranchVo;

/**
 * Created by moka on 2017/4/6 0006.
 */
public interface BranchService extends BasicService{
    int insert(BranchVo branchVo);

    BranchTo findOne(Integer id);

    Page findPage(BranchVo branchVo);
}
