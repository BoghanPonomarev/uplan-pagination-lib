package com.uplan.web;

import java.util.List;

public class PaginationListResponseBuilderImpl<T extends Paginable> implements PaginationListResponseBuilder<T> {

    @Override
    public PaginationEntitiesList<T> buildPaginationListResponse(PaginationRequestParams paginationRequestParams, List<T> resultEntityList) {
        Long responseSessionEntityTime = constructBackFeedSessionParam(paginationRequestParams, resultEntityList);
        return new PaginationEntitiesList<>(resultEntityList, responseSessionEntityTime);
    }

    private Long constructBackFeedSessionParam(PaginationRequestParams paginationRequestParams, List<T> resultEntityList) {
        if (paginationRequestParams.getPageNumber() == 1 && resultEntityList != null && !resultEntityList.isEmpty()) {
            T first = resultEntityList.get(0);

            return first.getCreationTime();
        }
        return paginationRequestParams.getEntitySessionTime();
    }

}
