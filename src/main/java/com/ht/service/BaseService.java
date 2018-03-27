package com.ht.service;

import com.ht.util.Pager;

import java.util.List;

/**
 * @auth Qiu
 * @time 2018/3/6
 **/
public interface BaseService {
    void save(Object obj);
    void remove(Object obj);
    void removeById(Long id);
    void update(Object obj);

    Object getById(Long id);
    List<Object> listAll();
    List<Object> listPager(Pager pager);
    Long count();

    List<Object> listPagerCriteria(Pager pager, Object obj);
    Long countCriteria(Object obj);
}
