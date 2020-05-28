import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from 'src/app/model/userLogin';
import { map } from 'rxjs/operators';
import { ApiService } from '../api-services/api.service';
import { UserProfile } from 'src/app/model/userProfile';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  //private _url: string = "http://localhost:8080/api/sessionController/login";
  private _getUserInfoUrl = "http://localhost:8080/api/users/returnCurrentUser";
  //private apiService: ApiService;
  currentUser;

  constructor(private _apiService: ApiService) { }
  /*
  public userLogin(userData){
    return this._httpClient.post<UserLogin>(this._url, userData);
  }
  */

  updateCurrentUser(name: string, surname: string){
    this.currentUser.name = name;
    this.currentUser.surname = surname;
  }

  public getMyInfo() {
    return this._apiService.get(this._getUserInfoUrl)
      .pipe(map(user => {
        this.currentUser = user;
        return user;
      }));
  }
}
