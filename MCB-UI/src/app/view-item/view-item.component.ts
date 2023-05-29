import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { Router } from '@angular/router';
import { FundRequestService } from '../service/fund-request.service';


@Component({
  selector: 'app-view-item',
  templateUrl: './view-item.component.html',
  styleUrls: ['./view-item.component.scss']
})
export class ViewItemComponent implements OnInit {

  @Input() itemData : any;
  @Output() action = new EventEmitter<any>()

  requestForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router : Router, private fundRequestService : FundRequestService) {
    this.requestForm = this.formBuilder.group({
      id: [''],
      business_key: [''],
      application: [''],
      comments : [''],
      transaction_currency : [''],
      transaction_amount : [''],
      amount_in_mur : [''],
      debit_account_number : [''],
      payment_details_1 : [''],
      payment_details_2 : [''],
      payment_details_3 : [''],
      payment_details_4 : [''],
      verified : [''],
      discrepancy_reason : [''],
      created_by : [''],
      created_on : [''],
      updated_by : [''],
      updated_on : [''],
      customer_number : [''],
      customer_name : [''],
      accountOfficer : [''],
      alt_account_officer : [''],
      date_mail_sent : [''],
      override : [''],
      bu_name : [''],
      amount_in_debit_account_ccy : [''],
      debit_account_balance : [''],
      beneficiary_account_number : [''],
      beneficiary_name : [''],
      beneficiary_bank_name : [''],
      beneficiary_bank_swift_code : [''],
      agreed_rate : [''],
      status : ['']

    })
   }

  ngOnInit(): void {
    // this.requestForm = this.itemData;
    console.log(this.requestForm);
    // this.requestForm.controls['application'].patchValue(this.itemData.application);
    this.requestForm.patchValue(this.itemData)
  }
  updateRecord(reqData : any){
    console.log(reqData);
    debugger
    this.fundRequestService.updateRecord(reqData,reqData.id).subscribe(res=>{
      this.back();
    })
  }

  back(){
    this.action.emit(true);
    // this.router.navigateByUrl(this.router.url);
  }


}
