package cn.bdqn.controller;

import cn.bdqn.common.PageSupport;
import cn.bdqn.common.Result;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.Sale;
import cn.bdqn.entity.Users;
import cn.bdqn.service.ProductService;
import cn.bdqn.service.SaleService;
import cn.bdqn.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Controller
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;
    @Autowired
    ProductService productService;
    @Autowired
    SaleService saleService;

    /**
     * @Author: hah
     * @Date: 2021-04-06 09:04:55
     * @Description: 进入主页
     * @return java.lang.String
     **/
    @RequestMapping("login")
    public String index(){
        return "login";
    }

    @RequestMapping("doLong")
    public String doLong(HttpServletRequest request, HttpServletResponse response, Users users, Model model){

        Result<Users> result = usersService.dologin(users);
        if ("200".equals(result.getCode())){
            HttpSession session =request.getSession();
            session.setAttribute("userSession",result.getData());
            return "index";
        }
        model.addAttribute("error",result.getMsg());
        return "login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("userSession");
        return "login";
    }

    /*进入欢迎页面*/
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    /*进入销售页面*/
    @RequestMapping("toAddSale")
    public String toAddSale(Model model){
        List<Product> productList = productService.queryAll();
        model.addAttribute("productList",productList);
        return "addSale";
    }

    /*添加Sale*/
    @ResponseBody
    @RequestMapping("doAddSale")
    public Result doAddSale(Sale sale,HttpSession session){
        return saleService.insert(sale, session);
    }
    /*public Result doAddSale(@RequestBody Sale sale,HttpSession session){
        return saleService.insert(sale, session);
    }*/


    /*toSaleList*/
    @RequestMapping("toSaleList")
    public String toSaleList(@RequestParam(value = "order", required = false) String order,Model model,Integer currentPage,Integer limit){
        limit = limit == null ? 4 : limit;
        currentPage = currentPage == null ? 1 : currentPage;
        order = order == null ? "sale_date" : order;
        System.out.println("order值为"+order);


        List<Sale> saleList = saleService.queryAllByLimit(order, currentPage, limit);
        Integer count = saleService.queryAllCount();
        Integer totalPageCount = (count+limit-1)/limit;
        PageSupport pageSupport = new PageSupport(currentPage,totalPageCount,count,saleList);

        model.addAttribute("order",order);
        model.addAttribute("pageSupport", pageSupport);
        return "toSaleList";
    }

}
