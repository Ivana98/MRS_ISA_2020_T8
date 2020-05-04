import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IUserProfile, UserProfile } from 'src/app/model/userProfile';
import { UserPassword } from 'src/app/model/userPassword';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  private _ulrGetUserData: string = "http://localhost:8080/getUserData";
  private _ulrSetUserData: string = "http://localhost:8080/setUserData";
  private _ulrSetUserPassword: string = "http://localhost:8080/setUserPassword";

  constructor(private _httpClient:HttpClient) {  }
  
  getUserData()
  {
    return this._httpClient.get<IUserProfile>(this._ulrGetUserData);
  }
  //all data except password
  // return true if data is succesfully written in database
  setUserData(user) : any
  {
    return this._httpClient.post<UserProfile>(this._ulrSetUserData, user);
  }
  //set user password
  // return true if data is succesfully written in database
  setUserPassword(password) : any
  {
    return this._httpClient.post<UserPassword>(this._ulrSetUserPassword, password);
  }

}
