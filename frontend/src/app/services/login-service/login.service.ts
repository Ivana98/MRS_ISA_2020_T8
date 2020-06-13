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

  private _getUserInfoUrl = "http://localhost:8080/api/users/returnCurrentUser";
  private _refresh_token_url = "http://localhost:8080/auth/refresh";

  currentUser;

  constructor(private _apiService: ApiService) { }

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

  initUser() {
    const promise = this._apiService.get(this._refresh_token_url).toPromise()
      .then(res => {
        if (res.access_token !== null) {
          return this.getMyInfo().toPromise()
            .then(user => {
              this.currentUser = user;
            });
        }
      })
      .catch(() => null);
    return promise;
  }

  setupUser(user) {
    this.currentUser = user;
  }

}
