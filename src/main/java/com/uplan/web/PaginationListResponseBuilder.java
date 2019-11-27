package com.uplan.web;

import java.util.List;

/**
 * API needed for constructing pagination response with pagination session support.
 *
 * @param <T>
 */
public interface PaginationListResponseBuilder<T extends Paginable> {

    PaginationEntitiesList<T> buildPaginationListResponse(PaginationRequestParams paginationRequestParams, List<T> resultEntityList);

}
