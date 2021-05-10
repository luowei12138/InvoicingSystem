package cn.bdqn.controller;

import cn.bdqn.entity.Sale;
import cn.bdqn.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sale)表控制层
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Controller
@RequestMapping("sale")
public class SaleController {
    /**
     * 服务对象
     */
    @Resource
    private SaleService saleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sale selectOne(Integer id) {
        return this.saleService.queryById(id);
    }

}
