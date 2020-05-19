import { Injectable } from '@angular/core';
import { HttpHeaders, HttpRequest, HttpResponse, HttpClient } from '@angular/common/http';
import {map, catchError, filter} from 'rxjs/operators';
import { Observable } from 'rxjs';
import { ApiService } from '../api-services/api.service';
import { LoginService } from '../login-service/login.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private _apiService: ApiService, private _loginService: LoginService, private _router: Router) {}

  headers = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  });

  private access_token = null;
  //private apiService: ApiService;

  login(user) {
    const loginHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });
    const body = {
      'username' : user.username,
      'password' : user.password
    };
    return this._apiService.post('http://localhost:8080/auth/login', JSON.stringify(body), loginHeaders)
      .pipe(map((res) => {
        console.log('Login success');
        this.access_token = res.accessToken;
      }));
  }

  logout() {
    this._loginService.currentUser = null;
    this.access_token = null; 
    this._router.navigate(['/login']);
  }

  tokenIsPresent() {
    return this.access_token != undefined && this.access_token != null;
  }

  getToken() {
    return this.access_token;
  }
}
