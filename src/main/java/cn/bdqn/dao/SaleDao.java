package cn.bdqn.dao;

import cn.bdqn.entity.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Sale)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
public interface SaleDao {

    List<Sale> queryAllByLimit(@Param("order") String order,@Param("offset") int offset, @Param("limit") int limit);
    /*总条数*/
    Integer queryAllCount();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sale queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Sale> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sale 实例对象
     * @return 对象列表
     */
    List<Sale> queryAll(Sale sale);

    /**
     * 新增数据
     *
     * @param sale 实例对象
     * @return 影响行数
     */
    int insert(Sale sale);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sale> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sale> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sale> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Sale> entities);

    /**
     * 修改数据
     *
     * @param sale 实例对象
     * @return 影响行数
     */
    int update(Sale sale);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

