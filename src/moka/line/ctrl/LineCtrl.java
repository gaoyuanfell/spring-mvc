package moka.line.ctrl;

import moka.basic.controller.BasicController;
import moka.line.service.LineService;
import moka.line.to.LineTo;
import moka.line.vo.LineVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by moka on 2017/4/6 0006.
 */
@Controller
@RequestMapping(value = "/line")
public class LineCtrl extends BasicController{
    @Resource
    private LineService lineService;

    /**
     * 增
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
     * 查
     * @param id
     * @return
     */
    @RequestMapping(value = "findOne.htm")
    @ResponseBody
    public Object findOne(int id) {
        LineTo lineTo = lineService.findOne(id);
        return result(lineTo);
    }
}
