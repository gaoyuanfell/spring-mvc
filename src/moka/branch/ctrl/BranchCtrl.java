package moka.branch.ctrl;

import moka.basic.ctrl.BasicController;
import moka.basic.page.Page;
import moka.branch.service.BranchService;
import moka.branch.to.BranchTo;
import moka.branch.vo.BranchVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
     * {
     * "url": "url",最多9个
     * "title": "测试",
     * "introduce": "测试测试测试测试测试",
     * "lineId": "5"
     * }
     *
     * @param branchVo
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody BranchVo branchVo) {
        int userId = getUserSessionId();
        branchVo.setUserId(userId);
        String url = branchVo.getUrl();
        if(!StringUtils.isEmpty(url)){
            String[] urls = branchVo.getUrl().split(",");
            if(urls.length > 9) return result(202,"最多9张图片");
        }
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
