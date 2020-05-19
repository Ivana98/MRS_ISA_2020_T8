import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { LoginService } from '../services/login-service/login.service';

@Injectable({
  providedIn: 'root'
})
export class PatientGuard implements CanActivate {
  constructor(private _router: Router, private _loginService: LoginService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this._loginService.currentUser) {
      if (this._loginService.currentUser.userAuthority === 'ROLE_PATIENT') {
        return true;
      } else {
        //user is not a patient
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
