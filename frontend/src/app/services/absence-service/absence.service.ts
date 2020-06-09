import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../login-service/login.service';
import { Absence } from 'src/app/model/absence';
import { AbsenceUser } from 'src/app/model/absenceUser';

@Injectable({
  providedIn: 'root'
})
export class AbsenceService {

  private _url: string = "http://localhost:8080/api/absences/";

  constructor(private _httpClient: HttpClient, private _loginService: LoginService) { }

  /**
   * Send absence request to clinic admin.
   * 
   * @param absence is Absence
   */
  public sendAbsenceRequest(absence) {
    absence.userId = this._loginService.currentUser.userId;
    
    return this._httpClient.post<Absence>(this._url + "addAbsence", absence);
  }

  public getAllFromClinic() {
    return this._httpClient.get<Array<Absence>>(this._url + "getAllFromClinic/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Confirm absence.
   * 
   * @param id is absence id
   */
  public confirm(id) {
    return this._httpClient.post<AbsenceUser>(this._url + "confirm", id);
  }

  /**
   * Deny absence.
   * 
   * @param id is absence id
   */
  public deny(id) {
    return this._httpClient.post<AbsenceUser>(this._url + "deny", id);
  }
}
