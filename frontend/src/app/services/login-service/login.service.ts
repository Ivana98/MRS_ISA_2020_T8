import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from 'src/app/model/userLogin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _url: string = "http://localhost:8080/api/sessionController/login";

  constructor(private _httpClient: HttpClient) { }

  public userLogin(userData){
    return this._httpClient.post<UserLogin>(this._url, userData);
  }
}
