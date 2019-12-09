package com.uplan.common;

public class PaginationSortParams {

    private PaginationSortRepositoryParam paginationSortRepositoryParam;
    private PaginationOrder paginationOrder;

    private PaginationSortParams(PaginationSortRepositoryParam paginationSortRepositoryParam, PaginationOrder paginationOrder) {
        this.paginationSortRepositoryParam = paginationSortRepositoryParam;
        this.paginationOrder = paginationOrder;
    }

    public static PaginationSortParams instanceOf(PaginationSortRepositoryParam paginationSortRepositoryParam, PaginationOrder paginationOrder) {
        return new PaginationSortParams(paginationSortRepositoryParam, paginationOrder);
    }

    public PaginationSortRepositoryParam getPaginationSortRepositoryParam() {
        return paginationSortRepositoryParam;
    }

    public PaginationOrder getPaginationOrder() {
        return paginationOrder;
    }

}
