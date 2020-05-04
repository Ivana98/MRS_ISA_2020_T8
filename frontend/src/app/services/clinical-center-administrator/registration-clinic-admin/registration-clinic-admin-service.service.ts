import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClinicAdmin } from 'src/app/model/clinicAdmin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationClinicAdminServiceService {

  private _url: string = "http://localhost:8080/api/clinicAdmin/save";

  constructor(private _httpClient:HttpClient) { }

  public addClinicAdmin(clinicAdmin) {
    
    return this._httpClient.post<ClinicAdmin>(this._url, clinicAdmin);
  }

}
