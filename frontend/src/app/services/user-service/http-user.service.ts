import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IUser, User } from '../../model/user';

@Injectable({
  providedIn: 'root'
})
export class HttpUserService {
  private _get_ulr: string = "http://localhost:8080/userdata";
  private _save_ulr: string = "http://localhost:8080/savechanges";

  constructor(private _httpClient:HttpClient) {  }

  getUserData()
  {
    return this._httpClient.get<IUser>(this._get_ulr);
  }

  public changeUserData(user) {
    return this._httpClient.post<User>(this._save_ulr, user);
  }
}
