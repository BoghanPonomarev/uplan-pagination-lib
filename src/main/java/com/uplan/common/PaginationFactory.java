package com.uplan.common;

import com.uplan.web.PaginationRequestParams;

public class PaginationFactory {

    private StaticPaginationParams staticPaginationParams;

    public PaginationFactory(StaticPaginationParams staticPaginationParams) {
        this.staticPaginationParams = staticPaginationParams;
    }

    public Pagination instanceOf(PaginationRequestParams paginationRequestParams) {
        return new Pagination(paginationRequestParams.getPageNumber(), paginationRequestParams.getEntitySessionTime(), staticPaginationParams);
    }

}
