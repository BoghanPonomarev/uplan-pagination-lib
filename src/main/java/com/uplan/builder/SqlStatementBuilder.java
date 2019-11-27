package com.uplan.builder;

public class SqlStatementBuilder {

    private static final int NOT_EXISTING_INDEX = -1;
    private static final String WHERE_STATEMENT = " WHERE ";

    private String originalStatement;
    private String additionalWhereStatement;
    private String limitStatementPart;
    private String sortStatementPart;

    private SqlStatementBuilder(String originalStatement) {
        this.originalStatement = originalStatement;
    }

    public static SqlStatementBuilder getInstance(String originalStatement) {
        return new SqlStatementBuilder(originalStatement);
    }

    public SqlStatementBuilder limit(int page, int pageSize) {
        this.limitStatementPart = " LIMIT " + (page - 1) * pageSize + ", " + pageSize;
        return this;
    }

    public SqlStatementBuilder sort(String sortingColumn, String sortingSequence) {
        this.sortStatementPart = " ORDER BY  " + sortingColumn + " " + sortingSequence;
        return this;
    }

    public SqlStatementBuilder sort(String sortingColumn) {
        this.sortStatementPart = " ORDER BY  " + sortingColumn + " ";
        return this;
    }

    public SqlStatementBuilder where(String additionalWhereStatement) {
        this.additionalWhereStatement = additionalWhereStatement;
        return this;
    }

    public String build() {
        StringBuilder resultStatement = new StringBuilder(originalStatement);
        appendAdditionalWhere(resultStatement, additionalWhereStatement);
        appendIfNotNull(resultStatement, sortStatementPart);
        appendIfNotNull(resultStatement, limitStatementPart);
        return resultStatement.toString();
    }

    private void appendIfNotNull(StringBuilder resultStatement, String statementPart) {
        if (statementPart != null) {
            resultStatement.append(statementPart);
        }
    }

    private void appendAdditionalWhere(StringBuilder resultStatement, String additionalWhereStatement) {
        int whereIndex = resultStatement.indexOf(WHERE_STATEMENT);
        if (whereIndex != NOT_EXISTING_INDEX && additionalWhereStatement != null && !additionalWhereStatement.isEmpty()) {
            resultStatement.append(additionalWhereStatement + " AND ", whereIndex, whereIndex + additionalWhereStatement.length());
        } else if (isShouldPreFillWithWhereCreating(resultStatement)) {
            preFillWherePart(resultStatement, additionalWhereStatement);
        } else {
            appendIfNotNull(resultStatement, WHERE_STATEMENT + additionalWhereStatement);
        }
    }

    private boolean isShouldPreFillWithWhereCreating(StringBuilder resultStatement) {
        return resultStatement.indexOf("GROUP BY") != NOT_EXISTING_INDEX
                && resultStatement.indexOf("HAVING") != NOT_EXISTING_INDEX;
    }

    private void preFillWherePart(StringBuilder resultStatement, String additionalWhereStatement) {
        int groupByIndex = resultStatement.indexOf("GROUP BY");
        int havingIndex = resultStatement.indexOf("HAVING");

        if (groupByIndex != NOT_EXISTING_INDEX) {
            resultStatement.append(WHERE_STATEMENT + additionalWhereStatement, groupByIndex,
                    groupByIndex + additionalWhereStatement.length());
        } else if (havingIndex != NOT_EXISTING_INDEX) {
            resultStatement.append(WHERE_STATEMENT + additionalWhereStatement, havingIndex,
                    havingIndex + additionalWhereStatement.length());
        }
    }

}
