package cn.bdqn.service.impl;

import cn.bdqn.common.Result;
import cn.bdqn.common.ResultEnum;
import cn.bdqn.common.ResultUtils;
import cn.bdqn.entity.Users;
import cn.bdqn.dao.UsersDao;
import cn.bdqn.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2021-04-06 09:18:51
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public Result<Users> dologin(Users users) {
        Users newUsers = usersDao.doLong(users.getUserName());
        if(ObjectUtils.isEmpty(newUsers)){
            //返回用户不存在
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_ACCOUNT_ISNULL);
        }
        else if(newUsers.getPassword().equals(users.getPassword())){
            //返回成功！
            return ResultUtils.returnDataSuccess(newUsers);
        }
        //返回用户，或密码错误
        return ResultUtils.returnResult(ResultEnum. FAIL_USER_LOGIN_ERROR);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer id) {
        return this.usersDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Users> queryAllByLimit(int offset, int limit) {
        return this.usersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.usersDao.deleteById(id) > 0;
    }
}
