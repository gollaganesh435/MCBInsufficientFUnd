import { Component, OnInit } from '@angular/core';
import { FundRequestService } from '../service/fund-request.service';
import { CURRENT_USER } from '../constants';

@Component({
  selector: 'app-fund-approval-answered',
  templateUrl: './fund-approval-answered.component.html',
  styleUrls: ['./fund-approval-answered.component.scss']
})
export class FundApprovalAnsweredComponent implements OnInit {

  constructor(private fundRequestService : FundRequestService) { }


  ngOnInit(): void {
    this.getVerifiedList();
  }

  fundReqList : any = [];

  getVerifiedList(){
    var username = JSON.parse(localStorage.getItem(CURRENT_USER)).username;
    this.fundRequestService.getVerifiedList(username).subscribe(res=>{
      this.fundReqList = res;
     
    })
  }

  
  

}
