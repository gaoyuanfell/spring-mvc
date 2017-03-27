package moka.basic.dao;

import moka.basic.page.Page;

import java.util.List;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicDao<T, P> {
    int insert(T t);

    P findOne(Integer id);

    List findPage(Page page);

    int findCount();
}
