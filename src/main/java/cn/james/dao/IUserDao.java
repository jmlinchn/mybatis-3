package cn.james.dao;


import cn.james.pojo.User;

import java.util.List;

/**
 * UserDao
 * @author James Lin
 * @date 2020/12/15
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

    /**
     * 根据条件查询用户
     * @param user 条件用户
     * @return
     */
    User selectByCondition(User user);

    /**
     * 添加用户
     * @param user 条件用户
     * @return
     */
    int insert(User user);

    /**
     * 更新用户
     * @param user 条件用户
     * @return
     */
    int updateById(User user);

    /**
     * 删除用户
     * @param id 主键标识
     * @return
     */
    int deleteById(Integer id);

}
