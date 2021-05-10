package cn.bdqn.service;

import cn.bdqn.common.Result;
import cn.bdqn.entity.Sale;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Sale)表服务接口
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
public interface SaleService {

    Result insert(Sale sale, HttpSession session);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sale queryById(Integer id);

    List<Sale> queryAllByLimit(@Param("order") String order, @Param("offset") int offset, @Param("limit") int limit);

    Integer queryAllCount();

    /**
     * 新增数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    /*Sale insert(Sale sale);*/

    /**
     * 修改数据
     *
     * @param sale 实例对象
     * @return 实例对象
     */
    Sale update(Sale sale);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
