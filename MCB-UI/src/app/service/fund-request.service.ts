import { Injectable } from '@angular/core';
import { HttpBaseService } from './http-base.service';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { API_PREFIX, LOCAL_TOKEN_KEY, httpHeaders } from '../constants';
import { AssignOfficer } from '../models/assign-officer.model';
import { ApprovalRequest } from '../models/approval-request.model';

@Injectable({
  providedIn: 'root'
})
export class FundRequestService {

  constructor(private http:HttpBaseService) { }

  getUnassinedList(): Observable<any> {
    const url = API_PREFIX + "request/unassigned";
    return this.http.requestTemplate('GET', url);
  }

  assignOfficer(assignOfc : AssignOfficer): Observable<any> {
    const url = API_PREFIX + "request/updateByOfficer";
    const options = Object.assign( {body: assignOfc});
    return this.http.requestTemplate('PUT', url,options);
  }

  getAssinedList(user : string): Observable<any> {
    const url = API_PREFIX + "request/officer?officerUsername="+user;
    return this.http.requestTemplate('GET', url);
  }

  getVerifiedList(user : string): Observable<any> {
    const url = API_PREFIX + "request/verified?userName="+user;
    return this.http.requestTemplate('GET', url);
  }

  approvalRequest(approvalReq : ApprovalRequest): Observable<any> {
    const url = API_PREFIX + "request/updatePayments";
    const options = Object.assign( {body: approvalReq});
    return this.http.requestTemplate('PUT', url,options);
  }

  getDashboardData(): Observable<any> {
    const url = API_PREFIX + "request/report";
    return this.http.requestTemplate('GET', url);
  }

  updateRecord(reqData : any, id : any): Observable<any> {
    const url = API_PREFIX + "request/"+id;
    const options = Object.assign( {body: reqData});
    return this.http.requestTemplate('PUT', url,options);
  }
}
