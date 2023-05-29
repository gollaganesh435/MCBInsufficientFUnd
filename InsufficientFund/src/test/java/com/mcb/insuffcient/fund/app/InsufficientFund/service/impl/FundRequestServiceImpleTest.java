package com.mcb.insuffcient.fund.app.InsufficientFund.service.impl;

import com.mcb.insuffcient.fund.app.InsufficientFund.controller.FundRequestController;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.AssignOfficerRequestDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.UpdatePaymentDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.FundRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.User;
import com.mcb.insuffcient.fund.app.InsufficientFund.repository.FundRequestRepository;
import com.mcb.insuffcient.fund.app.InsufficientFund.security.service.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class FundRequestServiceImpleTest {

    @InjectMocks
    private FundRequestServiceImpl service;

    @Mock
    private FundRequestRepository fundRequestRepository;

    @Mock
    private SecurityContextHolder securityContextHolder;


    @Test
    public void testAssignOfficer(){

        List<FundRequest> fundRequestList = new ArrayList<>();
        Mockito.when(fundRequestRepository.findAllByIdIn(Mockito.any())).thenReturn(fundRequestList);
        String userName = "System";
        UserDetailsImpl userDetails = new UserDetailsImpl(Long.valueOf(1),"System","Test");
        Authentication authentication = Mockito.mock(Authentication.class);
        User user = new User();
        Mockito.when(authentication.getPrincipal()).thenReturn(UserDetailsImpl.build(user));
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        service.assignOfficer(new AssignOfficerRequestDTO());

    }

    @Test
    public void testUpdatePaymentStatus(){

        List<FundRequest> fundRequestList = new ArrayList<>();
        Mockito.when(fundRequestRepository.findAllByIdIn(Mockito.any())).thenReturn(fundRequestList);
        String userName = "System";
        UserDetailsImpl userDetails = new UserDetailsImpl(Long.valueOf(1),"System","Test");
        Authentication authentication = Mockito.mock(Authentication.class);
        User user = new User();
        Mockito.when(authentication.getPrincipal()).thenReturn(UserDetailsImpl.build(user));
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        service.updatePaymentStatus(new UpdatePaymentDTO());

    }

    @Test
    public void testGetDayReport(){
        Mockito.when(fundRequestRepository.findByOptionalFields(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(5);
        service.getDayReport(null,null);

    }



}
