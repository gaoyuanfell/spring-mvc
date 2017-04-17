package moka.basic.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 * Created by moka on 2017/3/11.
 */
public class Page implements Serializable {
    private int pageIndex = 1;
    private int pageStart;
    private int pageSize = 5;
    private int totalPage;
    private int totalCount;
    private List list;

    public Page() {
    }

    public Page(int totalCount, List list) {
        this.setList(list);
        this.setTotalCount(totalCount);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        int pageSize = this.getPageSize();
        if (pageSize != 0 && pageIndex != 0) {
            this.setPageStart(pageSize * (pageIndex - 1));
        }
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        int pageIndex = this.getPageIndex();
        if (pageSize != 0 && pageIndex != 0) {
            this.setPageStart(pageSize * (pageIndex - 1));
        }
        this.pageSize = pageSize;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        int pageSize = this.getPageSize();
        if (totalCount != 0 && pageSize != 0) {
            int totalPage = totalCount / pageSize;
            if (totalCount % pageSize != 0) {
                ++totalPage;
            }
            this.setTotalPage(totalPage);
        }
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
