import { Component, OnInit } from '@angular/core';
import { FundRequestService } from '../service/fund-request.service';
import { DashboardReport } from '../models/dashboard-report.model';

@Component({
  selector: 'app-avilability-dashboard',
  templateUrl: './avilability-dashboard.component.html',
  styleUrls: ['./avilability-dashboard.component.scss']
})
export class AvilabilityDashboardComponent implements OnInit {

  constructor(private fundRequestService : FundRequestService) { }

  ngOnInit(): void {
    this.getVerifiedList();
  }

  dashboard = new DashboardReport();

  getVerifiedList(){
    // var username = JSON.parse(localStorage.getItem(CURRENT_USER)).username;
    this.fundRequestService.getDashboardData().subscribe(res=>{
      this.dashboard = res;
     
    })
  }

}
