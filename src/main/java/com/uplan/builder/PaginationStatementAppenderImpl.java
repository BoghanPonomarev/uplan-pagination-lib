package com.uplan.builder;

import com.uplan.common.Pagination;
import com.uplan.common.PaginationSortParams;
import com.uplan.common.StaticPaginationParams;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class PaginationStatementAppenderImpl implements PaginationStatementAppender {

    private String entityCreationTimeRepositoryParamName;

    public PaginationStatementAppenderImpl(String entityCreationTimeRepositoryParamName) {
        this.entityCreationTimeRepositoryParamName = " " + entityCreationTimeRepositoryParamName;
    }

    @Override
    public String appendPagination(String originalStatement, Pagination pagination) {
        StaticPaginationParams staticPaginationParams = pagination.getStaticPaginationParams();
        PaginationSortParams paginationSortParams = staticPaginationParams.getPaginationSortParams();

        return SqlStatementBuilder
                .getInstance(originalStatement)
                .where(buildWhereStatementPart(pagination))
                .limit(pagination.getPageNumber(), staticPaginationParams.getSize())
                .sort(paginationSortParams.getPaginationSortRepositoryParam().getRepositoryParamName(), paginationSortParams.getPaginationOrder().getOrderName())
                .build();
    }

    private String buildWhereStatementPart(Pagination pagination) {
        Long entitySessionTime = pagination.getEntitySessionTime();

        if (entitySessionTime != null) {
            LocalDateTime sessionEntityDate = toLocalDateTime(entitySessionTime);
            return entityCreationTimeRepositoryParamName + "<'" + Timestamp.valueOf(sessionEntityDate) + "' ";
        }
        return "";
    }

    private LocalDateTime toLocalDateTime(Long sessionEntityTime) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(sessionEntityTime), TimeZone.getDefault().toZoneId());
    }

}
