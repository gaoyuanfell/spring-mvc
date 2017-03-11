package moka.basic.dao;

import moka.basic.page.Page;

import java.util.List;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicDao<T> {
    int insert(T t);

    T findOne(Integer id);

    List<T> findList();

    Page<T> findPage(Page<T> page);
}
