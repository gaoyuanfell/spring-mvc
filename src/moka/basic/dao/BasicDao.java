package moka.basic.dao;

import java.io.Serializable;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicDao<T> {
    T findById(int id) throws Exception;

    int save(T t) throws Exception;

}
