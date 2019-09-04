package cn.aijiang.redis.service;

import cn.aijiang.redis.entity.User;

public interface UserService {

    /**
     * 保存或修改用户
     *
     * @param user 用户对象
     * @return 操作结果
     */
    User saveOrUpdate(User user);

    /**
     * 获取用户
     * @param id key值
     * @return 返回的结果
     */
    User get(Long id);

    /**
     * 删除
     * @param id key值
     */
    void delete(Long id);
}
