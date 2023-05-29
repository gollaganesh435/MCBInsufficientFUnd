import { Component, OnInit } from '@angular/core';
import { FundRequestService } from '../service/fund-request.service';
import { CURRENT_USER } from '../constants';
import { ApprovalRequest } from '../models/approval-request.model';

@Component({
  selector: 'app-fund-approval',
  templateUrl: './fund-approval.component.html',
  styleUrls: ['./fund-approval.component.scss']
})
export class FundApprovalComponent implements OnInit {

  selectedArray : any = [];
  constructor(private fundRequestService : FundRequestService) { }


  ngOnInit(): void {
    this.getAssignedList();
  }

  fundReqList : any = [];
  message : boolean = false;
  messageText : any = "";

  getAssignedList(){
    var username = JSON.parse(localStorage.getItem(CURRENT_USER)).username;
    this.fundRequestService.getAssinedList(username).subscribe(res=>{
      this.fundReqList = res;
     
    })
  }

  onCheckboxChange = (event: any) => {
    const { value, checked } = event.target;
    if(value !== "ALL"){
      const selectedItemIdx: any = this.fundReqList.findIndex(
        (x) => x.id === parseInt(value)
      );
      if (selectedItemIdx > -1) {
        if (checked) {
          this.selectedArray.push(this.fundReqList[selectedItemIdx]);
        } else this.selectedArray.splice(selectedItemIdx, 1);
      }
    } else {
      this.selectedArray = [];
      var checkboxes = document.getElementsByTagName('input');
        if (checked) {
          for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = true;
            }
        }
        this.selectedArray = this.fundReqList;
      } else{
        for (var i = 0; i < checkboxes.length; i++) {
          if (checkboxes[i].type == 'checkbox') {
              checkboxes[i].checked = false;
          }
      }
    }
  }
  };
  approveBatch(state:string) {
    var as = new ApprovalRequest();
    let idArr:any = [];
    this.selectedArray.forEach((element: any) => {
       idArr.push(element.id);
     });
     as.ids=idArr;
     as.username = JSON.parse(localStorage.getItem(CURRENT_USER)).username;
     if(state === "APPROVE"){
      as.status= "APPROVED";
      this.messageText = "Requests succesfully Approved..!"
     } else {
      as.status= "REJECT";
      this.messageText = "Requests succesfully Rejected..!"
     }
 
     this.fundRequestService.approvalRequest(as).subscribe(res=>{
       if(res){
        this.message = true;
        setTimeout(() => {
          console.log('hide');
          this.message = false;
          this.messageText = "";
        }, 2000);
         this.getAssignedList();
       }
     })
   }

}
