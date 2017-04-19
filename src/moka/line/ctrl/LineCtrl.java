package moka.line.ctrl;

import moka.basic.controller.BasicController;
import moka.basic.page.Page;
import moka.line.service.LineService;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;
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
@RequestMapping(value = "/line")
public class LineCtrl extends BasicController {
    @Resource
    private LineService lineService;

    /**
     * 增
     *
     * @param lineVo
     * @return
     */
    @RequestMapping(value = "insert.htm")
    @ResponseBody
    public Object insert(@RequestBody LineVo lineVo) {
        int i = lineService.insert(lineVo);
        return result(i);
    }

    /**
     * 查one
     *
     * @param lineVo
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(@RequestBody LineVo lineVo) {
        if(!StringUtils.isEmpty(lineVo.getId())){
            LineTo lineTo = lineService.findOne(lineVo.getId());
            return result(lineTo);
        }else{
            return result(CODE_PROMPT,"id不能为空");
        }
    }

    /**
     * 查 分页
     *
     * @return
     */
    @RequestMapping(value = "findPage.htm")
    @ResponseBody
    public Object findPage(@RequestBody LineVo lineVo) {
        Page list = lineService.findPage(lineVo);
        String[] s = {"1", "2", "3", "4", "5"};
        System.out.println(s);
        return result(list);
    }

    /**
     * 点赞+
     */
    @RequestMapping(value = "addPraised.htm")
    @ResponseBody
    public Object addPraised(@RequestBody LineVo lineVo){
        if(lineVo.getId() != 0){
            int i = lineService.addPraised(lineVo.getId());
            return result();
        }else{
            return result(CODE_PROMPT,"id不能为空");
        }
    }

    /**
     * 评论+
     */
    @RequestMapping(value = "addRepeat.htm")
    @ResponseBody
    public Object addRepeat(@RequestBody LineVo lineVo){
        if(lineVo.getId() != 0){
            int i = lineService.addRepeat(lineVo.getId());
            return result();
        }else{
            return result(CODE_PROMPT,"id不能为空");
        }
    }

    /**
     * 分享+
     */
    @RequestMapping(value = "addForward.htm")
    @ResponseBody
    public Object addForward(@RequestBody LineVo lineVo){
        if(lineVo.getId() != 0){
            int i = lineService.addForward(lineVo.getId());
            return result();
        }else{
            return result(CODE_PROMPT,"id不能为空");
        }
    }
}
