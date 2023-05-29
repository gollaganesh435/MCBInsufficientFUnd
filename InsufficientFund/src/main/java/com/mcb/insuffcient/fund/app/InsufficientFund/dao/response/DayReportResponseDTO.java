package com.mcb.insuffcient.fund.app.InsufficientFund.dao.response;

public class DayReportResponseDTO {

    private int approvedCount;

    private int rejectedCount;

    private int notHandledCount;

    public int getApprovedCount() {
        return approvedCount;
    }

    public void setApprovedCount(int approvedCount) {
        this.approvedCount = approvedCount;
    }

    public int getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(int rejectedCount) {
        this.rejectedCount = rejectedCount;
    }

    public int getNotHandledCount() {
        return notHandledCount;
    }

    public void setNotHandledCount(int notHandledCount) {
        this.notHandledCount = notHandledCount;
    }
}
