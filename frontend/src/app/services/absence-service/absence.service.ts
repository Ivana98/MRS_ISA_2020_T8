import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../login-service/login.service';
import { Absence } from 'src/app/model/absence';
import { AbsenceUser } from 'src/app/model/absenceUser';
import { AbsenceRequest } from 'src/app/model/absenceRequest';

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
   * @param absenceRequest is absence id and deny description
   */
  public confirm(absenceRequest) {
    return this._httpClient.put<AbsenceUser>(this._url + "confirm", absenceRequest);
  }

  /**
   * Deny absence.
   * 
   * @param absenceRequest is absence id and deny description
   */
  public deny(absenceRequest) {
    
    return this._httpClient.put<AbsenceRequest>(this._url + "deny", absenceRequest);
  }
}
