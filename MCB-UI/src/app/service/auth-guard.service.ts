import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { LoginServiceService } from './login-service.service';
import { CURRENT_USER } from '../constants';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
      private router: Router,
      private loginService: LoginServiceService,
      
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if (localStorage.getItem("currentUser") !== undefined) {
          this.loginService.user = JSON.parse(localStorage.getItem("currentUser"));
      }
      const currentUser = this.loginService.user;
      if (currentUser) {
          // authorised so return true
          return true;
      }

      // not logged in so redirect to login page with the return url
      this.router.navigate(['/login']);
      return false;
  }
}
