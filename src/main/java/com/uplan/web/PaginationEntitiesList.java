package com.uplan.web;

import java.util.List;

public class PaginationEntitiesList<T extends Paginable> {

    private List<T> entityList;
    private Long sessionEntityTime;

    public PaginationEntitiesList(List<T> entityList, Long sessionEntityTime) {
        this.entityList = entityList;
        this.sessionEntityTime = sessionEntityTime;
    }

    public List<T> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

    public Long getSessionEntityTime() {
        return sessionEntityTime;
    }

    public void setSessionEntityTime(Long sessionEntityTime) {
        this.sessionEntityTime = sessionEntityTime;
    }

}
