package com.mcb.insuffcient.fund.app.InsufficientFund.dao;

public enum FundRequestStatus {


    PROCEED("PROCEED"),
    REJECT("REJECT"),
    UNASSIGNED("UNASSIGNED"),

    ASSIGNED("ASSIGNED");
    private String name;

    FundRequestStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
