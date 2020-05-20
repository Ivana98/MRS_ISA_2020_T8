import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IMedicalRecords } from 'src/app/model/medicalRecords';
import { LoginService } from '../../login-service/login.service';
import { ApiService } from '../../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordsService {

  private _ulrMedicalRecords: string = "http://localhost:8080/api/patient/sendMedicalRecords";

  constructor(private _httpClient:HttpClient, private _loginService: LoginService, private _apiService: ApiService) {  }

  getMedicalRecords()
  {
    //return this._httpClient.post<IMedicalRecords>(this._ulrMedicalRecords, JSON.stringify(this._loginService.currentUser));
    return this._apiService.post(this._ulrMedicalRecords, JSON.stringify(this._loginService.currentUser.userId), this._apiService.headers);
  }
}
