package com.uplan.web;


public class PaginationRequestParams {

    private Integer pageNumber;
    private Long entitySessionTime;

    public PaginationRequestParams(Integer pageNumber, Long entitySessionTime) {
        this.pageNumber = pageNumber;
        this.entitySessionTime = entitySessionTime;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Long getEntitySessionTime() {
        return entitySessionTime;
    }
}
