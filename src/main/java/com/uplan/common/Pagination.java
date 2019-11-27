package com.uplan.common;

public class Pagination {

    private Integer pageNumber;
    private Long entitySessionTime;

    private StaticPaginationParams staticPaginationParams;

    Pagination(Integer pageNumber, Long entitySessionTime, StaticPaginationParams staticPaginationParams) {
        this.pageNumber = pageNumber;
        this.entitySessionTime = entitySessionTime;
        this.staticPaginationParams = staticPaginationParams;
    }

    public Long getEntitySessionTime() {
        return entitySessionTime;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public StaticPaginationParams getStaticPaginationParams() {
        return staticPaginationParams;
    }
}
