package com.ht.service.impl;

import com.ht.entity.User;
import com.ht.mapper.UserMapper;
import com.ht.service.UserService;
import com.ht.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @auth Qiu
 * @time 2018/3/6
 **/

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save(Object obj) {

    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public Object getById(Long id) {

        /**
         redisTemplate.opsForValue();//操作字符串
         redisTemplate.opsForHash();//操作hash
         redisTemplate.opsForList();//操作list
         redisTemplate.opsForSet();//操作set
         redisTemplate.opsForZSet();//操作有序set
         */
        ValueOperations<String,User> valueOperations=redisTemplate.opsForValue();

        //先要判断redis缓存里面是否有值  先根据键取值  判断值是否为空
        User user=valueOperations.get("user_"+id);
        if(user!=null){//说明redis缓存里面有值
            System.out.println("从缓存中取的数据");
            return user;
        }
        else{//redis缓存里面没值

            Object object=userMapper.getById(id);
            if(object!=null){//判断从数据库中拿出来的数据不为空  才写到缓存中
                valueOperations.set("user_"+id,(User) object);
            }
            System.out.println("从数据库中取的数据");
            return object;
        }
    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public List<Object> listPager(Pager pager) {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public List<Object> listPagerCriteria(Pager pager, Object obj) {
        return null;
    }

    @Override
    public Long countCriteria(Object obj) {
        return null;
    }
}
