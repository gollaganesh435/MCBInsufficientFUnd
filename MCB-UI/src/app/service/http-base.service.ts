import { HttpClient, HttpHandler, HttpHeaders, HttpParams, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginServiceService } from './login-service.service';
import { Observable, catchError, map, throwError } from 'rxjs';
import { LOCAL_TOKEN_KEY } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class HttpBaseService extends HttpClient{

  loginService: LoginServiceService;

  constructor(
    handler: HttpHandler,
    loginService: LoginServiceService
  ) {
    super(handler);
    this.loginService = loginService;
  }

  requestTemplate(first: string | HttpRequest<any>, url?: string, options: {
    
    body?: any,
    headers?: HttpHeaders | { [header: string]: string | string[] },
    params?: HttpParams | { [param: string]: string | string[] },
    reportProgress?: boolean,
    withCredentials?: boolean,
  } = {}, responseType?:string): Observable<any> {
      options.headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem(LOCAL_TOKEN_KEY),   
      });
    
    if (!responseType) {
      responseType = 'json';
    }
    const newOptions = Object.assign(options, { observe: 'response', responseType: responseType });
    return super.request<any>(first as string, url, options)
      .pipe(
        map((res: HttpResponse<any>) => res.body),
        catchError((err: any) => this.checkError(err))
      );
  }

  checkError(err: any): Observable<any> {

    if (err.status === 403) {
      this.loginService.logout();
    }
    
    const errObj:any = {};
    if (err.error && err.error.message) {
      errObj.message = err.error.message;
    } else {
      errObj.message = err.statusText + ': ' + err.message;
    }
    if (err.error && err.error.errors && err.error.errors.length
        && err.error.errors[0].field) {
     
      errObj.field = err.error.errors[0].field;
      if (err.error.errors[0].message != 'DataIntegrityViolationException') {
        errObj.message = err.error.errors[0].message;
      }
    }
 
    const errors = [errObj];
    return throwError(errors);
  }
}
