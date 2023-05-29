package com.mcb.insuffcient.fund.app.InsufficientFund.dao.request;

import java.util.List;

public class AssignOfficerRequestDTO {

    private List<Long> ids;

    private String officerUserName;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getOfficerUserName() {
        return officerUserName;
    }

    public void setOfficerUserName(String officerUserName) {
        this.officerUserName = officerUserName;
    }
}
