package cn.bdqn.service;

import cn.bdqn.common.Result;
import cn.bdqn.entity.Users;

import java.util.List;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
public interface UsersService {

    Result<Users> dologin(Users users);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Users queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Users> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
