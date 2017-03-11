package moka.basic.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 * Created by moka on 2017/3/11.
 */
public class Page<T> implements Serializable{
    int pageIndex;
    int pageSize;
    int totalPage;
    int totalCount;
    List<T> list;
}
