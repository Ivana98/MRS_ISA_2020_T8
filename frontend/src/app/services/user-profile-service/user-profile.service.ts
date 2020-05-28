import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IUserProfile, UserProfile } from 'src/app/model/userProfile';
import { UserPassword } from 'src/app/model/userPassword';
import { ApiService } from '../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  private _ulrGetUserData: string = "http://localhost:8080/api/users/getUserData";
  private _ulrSetUserData: string = "http://localhost:8080/api/users/setUserData";
  private _ulrSetUserPassword: string = "http://localhost:8080/api/users/setUserPassword";

  constructor(private _httpClient:HttpClient, private _apiService: ApiService) {  }
  
  getUserData()
  {
    return this._httpClient.get<IUserProfile>(this._ulrGetUserData);
  }
  //all data except password
  setUserData(user)
  {
    return this._apiService.post(this._ulrSetUserData, user, this._apiService.headers);
  }
  //set user password only
  setUserPassword(password)
  {
    return this._apiService.post(this._ulrSetUserPassword, password, this._apiService.headers);
  }

}
