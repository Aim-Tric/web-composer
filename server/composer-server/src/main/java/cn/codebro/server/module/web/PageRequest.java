package cn.codebro.server.module.web;

import java.io.Serializable;

public class PageRequest<T> implements Serializable {
    private Integer page;
    private Integer size;
    private T condition;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }
}
