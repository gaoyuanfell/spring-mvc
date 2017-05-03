package moka.branch.dao;

import moka.basic.dao.BasicDao;
import moka.basic.page.Page;
import moka.branch.bo.Branch;
import moka.branch.to.BranchTo;
import moka.branch.vo.BranchVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("branchDao")
public interface BranchDao extends BasicDao<Branch, BranchTo> {
    int addPraised(BranchVo branchVo);

    int addReview(BranchVo branchVo);

    List<BranchTo> findPageOfLine(BranchVo branchVo);


}
