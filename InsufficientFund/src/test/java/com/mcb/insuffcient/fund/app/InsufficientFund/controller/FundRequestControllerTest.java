package com.mcb.insuffcient.fund.app.InsufficientFund.controller;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.FundRequestStatus;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.AssignOfficerRequestDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.UpdatePaymentDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.response.DayReportResponseDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.FundRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.service.FundRequestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@ExtendWith(MockitoExtension.class)
class FundRequestControllerTest {


    @InjectMocks
    private FundRequestController controller;

    @Mock
    private FundRequestService service;

    @Test
    void testGetList() throws Exception {
        Mockito.when(service.getList()).thenReturn(new ArrayList<>());
        controller.getList();
        Mockito.verify(service, Mockito.times(1)).getList();
    }

    @Test
    void testGetUnassigned() throws Exception {
        Mockito.when(service.getUnassignedList()).thenReturn(new ArrayList<>());
        controller.getUnassigned();
        Mockito.verify(service, Mockito.times(1)).getUnassignedList();
    }

    @Test
    void testFindById() throws Exception {
        FundRequest fundRequest = new FundRequest();
        fundRequest.setStatus(FundRequestStatus.PROCEED);
        fundRequest.setUpdated_on(LocalDate.now());
        fundRequest.setId(Long.valueOf(1));
        Mockito.when(service.findById(Mockito.any())).thenReturn(Optional.of(fundRequest));
        controller.findById(Long.valueOf(1));
        Mockito.verify(service, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    void testGetbyOfficer() throws Exception {
        Mockito.when(service.getListByOfficer(Mockito.any())).thenReturn(new ArrayList<>());
        controller.getbyOfficer(Mockito.any());
        Mockito.verify(service, Mockito.times(1)).getListByOfficer(Mockito.any());
    }

    @Test
    void testGetVerifiedList() throws Exception {
        Mockito.when(service.getVerifiedList(Mockito.any())).thenReturn(new ArrayList<>());
        controller.getVerifiedList(Mockito.any());
        Mockito.verify(service, Mockito.times(1)).getVerifiedList(Mockito.any());
    }

    @Test
    void testUpdateOfficer() throws Exception {
        Mockito.when(service.assignOfficer(Mockito.any())).thenReturn(new ArrayList<>());
        controller.updateOfficer(Mockito.any());
        Mockito.verify(service, Mockito.times(1)).assignOfficer(Mockito.any());
    }

    @Test
    void testUpdatePayments() throws Exception {
        Mockito.when(service.updatePaymentStatus(Mockito.any())).thenReturn(new ArrayList<>());
        controller.updatePayments(Mockito.any());
        Mockito.verify(service, Mockito.times(1)).updatePaymentStatus(Mockito.any());
    }


}
