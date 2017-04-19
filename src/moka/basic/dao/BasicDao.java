package moka.basic.dao;

import moka.basic.page.Page;

import java.util.List;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicDao<E, T> {
    int insert(E e);

    T findOne(Integer id);

    List findList(Page page);

    List findPage(Page page);

    int findCount();
}
