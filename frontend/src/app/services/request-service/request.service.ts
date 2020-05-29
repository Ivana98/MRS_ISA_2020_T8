import { Injectable } from '@angular/core';
import { ApiService } from '../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  private _ulrSendRequest: string = "http://localhost:8080/api/users/getUserData"; //change

  constructor(private _apiService: ApiService) { }

  sendRegistrationRequest(request)
  {
    return this._apiService.post(this._ulrSendRequest, request, this._apiService.headers);
  }
}
