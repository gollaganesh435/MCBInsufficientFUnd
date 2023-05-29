package com.mcb.insuffcient.fund.app.InsufficientFund.service;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.AssignOfficerRequestDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.DayReportResponseDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.FundRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.UpdatePaymentDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FundRequestService {

    List<FundRequest> getList();

    List<FundRequest> getUnassignedList();

    Optional<FundRequest> findById(Long id);

    List<FundRequest> getListByOfficer(String officerUserName);

    List<FundRequest> getVerifiedList(String officerUserName);

    List<FundRequest> assignOfficer(AssignOfficerRequestDTO assignOfficerRequestDTO);

    List<FundRequest> updatePaymentStatus(UpdatePaymentDTO updatePaymentDTO);

    FundRequest updateRequest(FundRequest fundRequest);

    DayReportResponseDTO getDayReport(LocalDate date, String user);


}
