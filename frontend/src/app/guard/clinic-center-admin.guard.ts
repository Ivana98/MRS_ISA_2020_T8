import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../services/login-service/login.service';

@Injectable({
  providedIn: 'root'
})
export class ClinicCenterAdminGuard implements CanActivate {
  constructor(private _router: Router, private _loginService: LoginService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this._loginService.currentUser) {
      if (this._loginService.currentUser.userAuthority === 'ROLE_CLINIC_CENTER_ADMIN') {
        return true;
      } else {
        //user is not a clinical center admin
        this._router.navigate(['/403']);
        return false;
      }
    } 
    else {
      //current user does not exist - no one is logged in
      this._router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
      return false;
    }
  }
  
}
