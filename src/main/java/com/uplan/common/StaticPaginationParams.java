package com.uplan.common;

public class StaticPaginationParams {

    private Integer size;
    private PaginationSortParams paginationSortParams;

    private StaticPaginationParams(Integer size, PaginationSortParams paginationSortParams) {
        this.size = size;
        this.paginationSortParams = paginationSortParams;
    }

    public StaticPaginationParams of(Integer size, PaginationSortParams paginationSortParams) {
        return new StaticPaginationParams(size, paginationSortParams);
    }

    public PaginationSortParams getPaginationSortParams() {
        return paginationSortParams;
    }

    public Integer getSize() {
        return size;
    }

}
