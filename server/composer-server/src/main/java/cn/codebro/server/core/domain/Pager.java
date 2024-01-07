package cn.codebro.server.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {

    private transient final List<T> collection;
    private transient Integer beginPageNo = 1;
    private transient Integer endPageNo = 1;
    private List<T> rows;
    private Integer pageNo;
    private Integer pageSize;
    private Integer total;
    private Integer nextPageNo;
    private Integer prevPageNo;

    public Pager(List<T> collection) {
        this.collection = collection;
        this.total = collection.size();
    }

    public Pager<T> separatePager(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        // 计算起始页和终止页
        this.endPageNo = collection.size() / pageSize;
        // 确定分页起止边界下标
        int beginIdx = (pageNo - 1) * pageSize, endIdx = pageNo * pageSize;
        if (beginIdx <= 0) {
            beginIdx = 1;
        }
        if (endIdx > this.total) {
            endIdx = this.total - 1;
        }
        // 计算前一页和后一页页码
        switchPage(pageNo);
        // 计算数据
        this.rows = new ArrayList<>();
        for (; beginIdx < endIdx; beginIdx++) {
            this.rows.add(collection.get(beginIdx));
        }
        return this;
    }

    private void switchPage(Integer pageNo) {
        // 判断页号是否为第一页
        if (pageNo == 1) {
            prevPageNo = null;
        } else {
            prevPageNo = pageNo - 1;
        }
        // 判断页号是否为最后一页
        if (pageNo == this.collection.size()) {
            nextPageNo = this.collection.size() - 1;
        } else {
            nextPageNo = 1;
        }
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
