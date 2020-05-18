import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MedicalRoom } from 'src/app/model/medicalRoom';
import { Examination } from 'src/app/model/examination';

@Injectable({
  providedIn: 'root'
})
export class ClinicAdminService {

  private _url: string = "http://localhost:8080/api/clinicAdmins/";

  constructor(private _httpClient: HttpClient) { }

  public getRoomsFromClinic(admin) {
    return this._httpClient.get<Array<MedicalRoom>>(this._url + "getRoomsFromClinic/" + admin);
  }
}
