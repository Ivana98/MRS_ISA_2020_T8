import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { LoginService } from '../services/login-service/login.service';

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {
  constructor(private router: Router, private loginService: LoginService) {
  }

  canActivate(): boolean {
    if (this.loginService.currentUser) {
      return true;
    } else {
      this.router.navigate(['/']);
      return false;
    }
  }
  
}
