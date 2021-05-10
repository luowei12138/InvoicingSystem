package cn.bdqn.service.impl;

import cn.bdqn.common.Result;
import cn.bdqn.common.ResultEnum;
import cn.bdqn.common.ResultUtils;
import cn.bdqn.dao.ProductDao;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.Sale;
import cn.bdqn.dao.SaleDao;
import cn.bdqn.entity.Users;
import cn.bdqn.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.List;

/**
 * (Sale)表服务实现类
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Service("saleService")
public class SaleServiceImpl implements SaleService {
    @Resource
    private SaleDao saleDao;

    @Autowired
    ProductDao productDao;

    @Override
    public Result insert(Sale sale, HttpSession session) {

        System.out.println(""+sale.getPrice());
        System.out.println(""+sale.getQuantity());
        System.out.println(""+sale.getProductId());

        //查询选择的商品
        Product product = productDao.queryById(sale.getProductId());
        //商品ID
        System.out.println("product"+product.getId());
        //获取新库存：旧的库存-要添加的销售的库存
        int newQuan = (product.getQuantity()-sale.getQuantity());
        //修改选择的商品的库存
        product.setQuantity(newQuan);
        productDao.update(product);

        //添加销售
        //获取session中的UserId
        sale.setUserId(((Users) session.getAttribute("userSession")).getId());

        DecimalFormat df = new DecimalFormat("#.00");
        Double sum = Double.parseDouble(df.format(sale.getPrice() * sale.getQuantity()));
        //添加总价
        sale.setTotalPrice(sum);

        int num =saleDao.insert(sale);
        if(num == 1){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnResult(ResultEnum.FAIL_USER_ADD_ERROR);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sale queryById(Integer id) {
        return this.saleDao.queryById(id);
    }

    /**
     * @Author: hah
     * @Date: 2021-04-06 15:04:52
     * @Description: 分页查询
     * @param order
     * @param offset
     * @param limit
     * @return java.util.List<cn.bdqn.entity.Sale>
     **/
    @Override
    public List<Sale> queryAllByLimit(String order, int offset, int limit) {
        return saleDao.queryAllByLimit(order,(offset-1)*limit,limit);
    }

    @Override
    public Integer queryAllCount() {
        return saleDao.queryAllCount();
    }


    /**
     * 新增数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
   /* @Override
    public Sale insert(Sale sale) {
        this.saleDao.insert(sale);
        return sale;
    }*/

    /**
     * 修改数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    @Override
    public Sale update(Sale sale) {
        this.saleDao.update(sale);
        return this.queryById(sale.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleDao.deleteById(id) > 0;
    }
}
