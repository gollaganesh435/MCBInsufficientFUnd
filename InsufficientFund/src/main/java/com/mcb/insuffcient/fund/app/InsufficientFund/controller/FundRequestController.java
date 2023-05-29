package com.mcb.insuffcient.fund.app.InsufficientFund.controller;

import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.AssignOfficerRequestDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.dao.request.UpdatePaymentDTO;
import com.mcb.insuffcient.fund.app.InsufficientFund.modal.FundRequest;
import com.mcb.insuffcient.fund.app.InsufficientFund.service.FundRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/request")
public class FundRequestController {

    @Autowired
    FundRequestService fundRequestService;


    @GetMapping("/list")
    public ResponseEntity<?> getList(){
        return new ResponseEntity<>(fundRequestService.getList(), HttpStatus.OK);
    }

    @GetMapping("/unassigned")
    public ResponseEntity<?> getUnassigned(){
        return new ResponseEntity<>(fundRequestService.getUnassignedList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(fundRequestService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/officer")
    public ResponseEntity<?> getbyOfficer(@RequestParam String officerUsername){
        return new ResponseEntity<>(fundRequestService.getListByOfficer(officerUsername), HttpStatus.OK);
    }

    @GetMapping("/verified")
    public ResponseEntity<?> getVerifiedList(@RequestParam String userName){
        return new ResponseEntity<>(fundRequestService.getVerifiedList(userName), HttpStatus.OK);
    }


    @PutMapping("/updateByOfficer")
    public ResponseEntity<?> updateOfficer(@RequestBody AssignOfficerRequestDTO assignOfficerRequestDTO){
        return new ResponseEntity<>(fundRequestService.assignOfficer(assignOfficerRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/updatePayments")
    public ResponseEntity<?> updatePayments(@RequestBody UpdatePaymentDTO updatePaymentDTO){
        return new ResponseEntity<>(fundRequestService.updatePaymentStatus(updatePaymentDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRequest(@RequestBody FundRequest request){
        return new ResponseEntity<>(fundRequestService.updateRequest(request), HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<?> getDayReport(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @RequestParam(required = false) String user){
        return new ResponseEntity<>(fundRequestService.getDayReport(date, user), HttpStatus.OK);
    }


}
