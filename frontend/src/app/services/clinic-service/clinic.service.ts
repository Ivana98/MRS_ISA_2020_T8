import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICLinicToDisplay } from 'src/app/model/clinic';
import { ClinicBasic } from 'src/app/model/clinicBasic';
import { LoginService } from '../login-service/login.service';
import { StartEndDateClinicId } from 'src/app/model/StartEndDateClinicId';

@Injectable({
  providedIn: 'root'
})
export class ClinicService {

  private _url: string = "http://localhost:8080/api/clinics/";

  constructor(private _httpClient: HttpClient, private _loginService: LoginService) { }

  /*
    return list of id and name of all clinics
  */
  public getAll(): Observable<Array<ICLinicToDisplay>>
  {
    return this._httpClient.get<Array<ICLinicToDisplay>>(this._url + "getAll");
  }

  public getOne(id) {
    return this._httpClient.get<ClinicBasic>(this._url + "getOne/" + id);
  }

  public modify(clinic) {
    return this._httpClient.put<ClinicBasic>(this._url + "modify", clinic);
  }

  /**
   * return average mark of clinic.
   */
  public getClinicAverageMark() {
    return this._httpClient.get<number>(this._url + "getAverageMark/" + this._loginService.currentUser.clinicId);
  }

  /**
   * return total income from choosen start to choosen end date.
   * 
   * @param startEndDateClinicId is object with start, end date and clinic id
   */
  public getIncome(startDate, endDate) {
    return this._httpClient.get<number>(this._url + "getIncome/" + startDate + "/" + endDate + "/" + this._loginService.currentUser.clinicId);
  }

}
