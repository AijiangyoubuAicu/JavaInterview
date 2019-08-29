package cn.aijiang.mapper;

import cn.aijiang.entity.User;

/**
 * Mapper 映射接口
 */
public interface UserMapper {

    /**
     * 查询数据库中用户的行数
     * @return 用户的总数
     */
    Integer count();
}
