import { Component, OnInit } from '@angular/core';
import { FundRequestService } from '../service/fund-request.service';
import { AssignOfficer } from '../models/assign-officer.model';
import { CURRENT_USER } from '../constants';

@Component({
  selector: 'app-fund-availability-list',
  templateUrl: './fund-availability-list.component.html',
  styleUrls: ['./fund-availability-list.component.scss']
})
export class FundAvailabilityListComponent implements OnInit {

  selectedArray : any = [];



  view = 'table';
  viewItem : any;
  tableList : any;
  message : boolean = false;
  messageText : any = "";

  constructor(private fundRequestService : FundRequestService) { }

  ngOnInit(): void {
    this.view = 'table';
    this.getUnAssignedList();
  }

  unassinedList : any = [];

  getUnAssignedList(){
    this.fundRequestService.getUnassinedList().subscribe(res=>{
      this.unassinedList = res;
        this.tableList = res;
     
    })
  }

  onCheckboxChange = (event: any) => {
    const { value, checked } = event.target;
    if(value !== "ALL"){
      const selectedItemIdx: any = this.tableList.findIndex(
        (x) => x.id === parseInt(value)
      );
      if (selectedItemIdx > -1) {
        if (checked) {
          this.selectedArray.push(this.tableList[selectedItemIdx]);
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
        this.selectedArray = this.tableList;
      } else{
        for (var i = 0; i < checkboxes.length; i++) {
          if (checkboxes[i].type == 'checkbox') {
              checkboxes[i].checked = false;
          }
      }
    }
  }
}

  acceptRecords() {
   var as = new AssignOfficer();
   let idArr:any = [];
   this.selectedArray.forEach((element: any) => {
      idArr.push(element.id);
    });
    as.ids=idArr;
    as.username = JSON.parse(localStorage.getItem(CURRENT_USER)).username;

    this.fundRequestService.assignOfficer(as).subscribe(res=>{
      if(res){
        this.messageText = "Records successufully assigned...!";
        this.message = true;
        setTimeout(() => {
          console.log('hide');
          this.message = false;
          this.messageText = "";
        }, 2000);
        this.getUnAssignedList();
      }
    })
  }

  viewForm(item:any) {
    this.viewItem = item;
    this.view = "model";
  }

  getAction(state: any){
    console.log(state);
    this.view = 'table';
    this.getUnAssignedList();

  }

}
