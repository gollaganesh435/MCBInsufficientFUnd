package com.mcb.insuffcient.fund.app.InsufficientFund.dao.request;

import java.util.List;

public class UpdatePaymentDTO {

    private List<Long> ids;

    private String status;

    private String username;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
