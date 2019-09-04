package cn.aijiang.redis.service.impl;

import cn.aijiang.redis.entity.User;
import cn.aijiang.redis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * 模拟数据库
     */
    private static final Map<Long, User> DATABASE = new ConcurrentHashMap<>();

    /**
     * 加入数据
     */
    static {
        DATABASE.put(1L, new User(1L, "user1"));
        DATABASE.put(2L, new User(2L, "user2"));
        DATABASE.put(3L, new User(3L, "user3"));
    }

    /**
     * 保存和修改数据
     * @param user 用户对象
     * @return 操作结果
     */
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        DATABASE.put(user.getId(), user);
        log.info("保存用户【user】= {}", user);
        return user;
    }

    /**
     * 获取用户
     * @param id key值
     * @return 返回结果
     */
    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        // 假设从数据库读取
        log.info("查询用户【id】= {}", id);
        return DATABASE.get(id);
    }

    /**
     *
     * @param id key值
     */
    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        DATABASE.remove(id);
        log.info("删除用户【id】= {}", id);
    }
}
