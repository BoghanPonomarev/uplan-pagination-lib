package com.uplan.builder;

import com.uplan.common.Pagination;

public interface PaginationStatementAppender {

    String appendPagination(String originalStatement, Pagination pagination);

}
