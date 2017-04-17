package moka.branch.ctrl;

import moka.basic.controller.BasicController;
import moka.basic.page.Page;
import moka.branch.service.BranchService;
import moka.branch.to.BranchTo;
import moka.branch.vo.BranchVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Controller
@RequestMapping(value = "/branch")
public class BranchCtrl extends BasicController {
    @Resource
    private BranchService branchService;

    /**
     * 增
     *
     * @param branchVo
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody BranchVo branchVo) {
        int i = branchService.insert(branchVo);
        return result(i);
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(int id) {
        BranchTo branchTo = branchService.findOne(id);
        return result(branchTo);
    }

    /**
     * 查 分页
     *
     * @return
     */
    @RequestMapping(value = "findPage.htm")
    @ResponseBody
    public Object findPage(@RequestBody BranchVo branchVo) {
        Page list = branchService.findPage(branchVo);
        return result(list);
    }
}
