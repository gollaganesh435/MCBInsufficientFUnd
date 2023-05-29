package com.mcb.insuffcient.fund.app.InsufficientFund.service.impl;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.AssignOfficerRequestDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.DayReportResponseDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.FundRequestStatus;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.UpdatePaymentDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.*;
import com.mcb.insuffcient.fund.app.InsufficientFund.repository.FundRequestRepository;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.service.UserDetailsImpl;
import com.mcb.insuffcient.fund.app.InsufficientFund.service.FundRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FundRequestServiceImpl implements FundRequestService {

    @Autowired
    FundRequestRepository fundRequestRepository;

    /**
     * Find List of request.
     *
     *
     * @return the List
     */
    @Override
    public List<FundRequest> getList() {
        return fundRequestRepository.findAll();
    }

    /**
     * Find Un-assigned List of request.
     *
     * @return the List
     */
    @Override
    public List<FundRequest> getUnassignedList() {
        return fundRequestRepository.findByStatus(FundRequestStatus.UNASSIGNED);
    }

    /**
     * Find By Id of request.
     *
     * @return the FundRequest Object
     */
    @Override
    public Optional<FundRequest> findById(Long id) {
        return fundRequestRepository.findById(id.toString());
    }

    /**
     * Find Assignes with officer name of request.
     *
     * @return the List
     */
    @Override
    public List<FundRequest> getListByOfficer(String officerUserName) {
        return fundRequestRepository.findByAccountOfficerAndStatus(officerUserName, FundRequestStatus.ASSIGNED);
    }

    /**
     * Find Assigned and approved(or)Rejected List of request.
     *
     * @return the List
     */

    @Override
    public List<FundRequest> getVerifiedList(String officerUserName) {
        return fundRequestRepository.findByAccountOfficerAndVerified(officerUserName,"YES");
    }
    /**
     * Update Officer details to List of request.
     *
     * @return the List
     */
    @Override
    public List<FundRequest> assignOfficer(AssignOfficerRequestDTO assignOfficerRequestDTO) {
        List<FundRequest> reqList = fundRequestRepository.findAllByIdIn(assignOfficerRequestDTO.getIds());
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String updatedBy = userDetails.getUsername();
        for(FundRequest req : reqList){
            req.setAccountOfficer(updatedBy);
            req.setStatus(FundRequestStatus.ASSIGNED);
            req.setUpdated_on(LocalDate.now());
            req.setUpdated_by(updatedBy);
        }
       return fundRequestRepository.saveAll(reqList);
    }

    /**
     * Update payment status details to List of request.
     *
     * @return the List
     */

    @Override
    public List<FundRequest> updatePaymentStatus(UpdatePaymentDTO updatePaymentDTO) {
        List<FundRequest> reqList = fundRequestRepository.findAllByIdIn(updatePaymentDTO.getIds());
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String updatedBy = userDetails.getUsername();
        for(FundRequest req : reqList){
            if(updatePaymentDTO.getStatus().equals("APPROVED")){
                req.setVerified("YES");
                req.setStatus(FundRequestStatus.PROCEED);
                req.setUpdated_by(updatedBy);
                req.setUpdated_on(LocalDate.now());
            } else {
                req.setVerified("YES");
                req.setStatus(FundRequestStatus.REJECT);
                req.setUpdated_by(updatedBy);
                req.setUpdated_on(LocalDate.now());
            }

        }
        return fundRequestRepository.saveAll(reqList);
    }
    /**
     * update Object with id of request.
     *
     * @return FundRequest obj
     */
    @Override
    public FundRequest updateRequest(FundRequest fundRequest) {
        return fundRequestRepository.save(fundRequest);
    }

    /**
     * Find Dashboard metrics to List of request.
     *
     * @return DayReportResponseDTO obj
     */
    public DayReportResponseDTO getDayReport(LocalDate date, String user) {
        DayReportResponseDTO dayReportResponseDTO = new DayReportResponseDTO();
        if(user != null){
            UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
             user = userDetails.getUsername();
        }


        dayReportResponseDTO.setApprovedCount(fundRequestRepository.findByOptionalFields(FundRequestStatus.PROCEED, Optional.ofNullable(date),Optional.ofNullable(user)));
        dayReportResponseDTO.setRejectedCount(fundRequestRepository.findByOptionalFields(FundRequestStatus.REJECT,Optional.ofNullable(date),Optional.ofNullable(user)));
        dayReportResponseDTO.setNotHandledCount(fundRequestRepository.findByOptionalFields(FundRequestStatus.ASSIGNED,Optional.ofNullable(date),Optional.ofNullable(user)));
        return dayReportResponseDTO;
    }
}
