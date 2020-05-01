import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IUserProfile } from 'src/app/model/userProfile';


@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  private _ulrUserData: string = "http://localhost:8080/getUserData";

  constructor(private _httpClient:HttpClient) {  }
  
  getUserData()
  {
    return this._httpClient.get<IUserProfile[]>(this._ulrUserData);
  }
}
