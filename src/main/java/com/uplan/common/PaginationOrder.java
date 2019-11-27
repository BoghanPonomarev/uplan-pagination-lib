package com.uplan.common;

public enum PaginationOrder {
    ASC("ASC"),
    DESC("DESC");

    private String orderName;

    PaginationOrder(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName() {
        return orderName;
    }

}