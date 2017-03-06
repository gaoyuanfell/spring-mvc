package moka.basic.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Repository("BasicDao")
public class BasicDaoImpl<T> implements BasicDao<T> {
    @Override
    public T findById(int id) throws Exception {
        return null;
    }

    @Override
    public int save(T t) throws Exception {
        return 0;
    }
}
