package cn.bdqn.controller;

import cn.bdqn.entity.Product;
import cn.bdqn.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2021-04-06 09:18:49
 */
@Controller
@RequestMapping("product")
public class ProductController {

    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Product selectOne(Integer id) {
        return this.productService.queryById(id);
    }


    @RequestMapping("queryQuantity")
    public String toProductList(@RequestParam(value = "id", required = false) Integer id,
                                Model model) {
        if (!ObjectUtils.isEmpty(id)) {
            model.addAttribute("quantity", productService.queryById(id).getQuantity());
        }
        model.addAttribute("id", id);
        model.addAttribute("list", productService.queryAllByLimit(0, 100));
        
        return "toProductList";
    }

}
