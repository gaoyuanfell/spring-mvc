package moka.branch.dao;

import moka.basic.dao.BasicDao;
import moka.branch.bo.Branch;
import moka.branch.to.BranchTo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Repository("branchDao")
public interface BranchDao extends BasicDao<Branch, BranchTo> {

}
