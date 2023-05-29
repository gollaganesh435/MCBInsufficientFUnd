import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { User } from '../models/user.model';
import { Observable, tap } from 'rxjs';
import { API_PREFIX, CURRENT_USER, LOCAL_TOKEN_KEY, httpHeaders } from '../constants';
import { Router } from '@angular/router';
const authHeaderPrefix = "Bearer ";

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  user: User = null;

  constructor(private http : HttpClient,private router: Router) { }

  login(userName: string, password: string): Observable<HttpResponse<User>> {
    const data = { userName, password };
    return this.http.post<User>(API_PREFIX + "user/signin", data, { headers: httpHeaders, observe: 'response' }).pipe(
      tap((res: HttpResponse<User>) => this.handleAuthResponse(res))
    );
  }

  logout(): void {
    // TODO: send request to server
    localStorage.removeItem(LOCAL_TOKEN_KEY);
    localStorage.removeItem(CURRENT_USER);
    this.router.navigateByUrl('/login');
  }


  handleAuthResponse(res: HttpResponse<User>) {

    localStorage.removeItem(CURRENT_USER);
    if (res.status === 200) {

      this.user = res.body as User;
      localStorage.setItem(CURRENT_USER, JSON.stringify(this.user));

      var authHeader = res.body.accessToken;
      //  token = authHeader;
      localStorage.setItem(LOCAL_TOKEN_KEY, authHeader);
    }
  }
}
