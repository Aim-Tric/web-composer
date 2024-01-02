package cn.codebro.server.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {

    private transient final List<T> collection;
    private List<T> rows;
    private Integer pageNo;
    private Integer pageSize;
    private Integer total;

    public Pager(List<T> collection) {
        this.collection = collection;
    }

    public Pager<T> getPager(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = collection.size();
        // 确定分页起止边界下标
        int beginIdx = (pageNo - 1) * pageSize, endIdx = pageNo * pageSize;
        if (endIdx > this.total) {
            endIdx = this.total - 1;
        }
        this.rows = new ArrayList<>();
        for (; beginIdx < endIdx; beginIdx++) {
            this.rows.add(collection.get(beginIdx));
        }
        return this;
    }

    public List<T> getRows() {
        return rows;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotal() {
        return total;
    }
}
