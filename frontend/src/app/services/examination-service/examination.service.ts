import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Examination } from 'src/app/model/examination';
import { LoginService } from '../login-service/login.service';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  private _url: string = "http://localhost:8080/api/examinations/";

  constructor(private _httpClient: HttpClient, private _loginService: LoginService) { }

  /**
   * Adding one click free examination.
   * 
   * @param examination is Examination
   * @returns added Examination or null if not added.
   */
  public addFreeExamination(examination) {
    return this._httpClient.post<Examination>(this._url + "saveOneClickExamination", examination);
  }

  public loadAllFreeExaminationsFromClinic() {
    return this._httpClient.get<Array<Examination>>(this._url + "getAllFreeFromClinic/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Delete examination by id.
   * 
   * @param id is Examination ID
   */
  public delete(id) {
    return this._httpClient.delete(this._url + "delete/" + id);
  }

}
