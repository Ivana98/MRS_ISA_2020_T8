import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient, PatientForNurse } from 'src/app/model/patient';
import { Observable } from 'rxjs';
import { LoginService } from '../login-service/login.service';


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private _url: string = "http://localhost:8080/api/patients/";

  private _urlGetAll: string = "http://localhost:8080/api/patients/getAllForNurse";//f
  private _urlGetOne: string = "http://localhost:8080/api/patients/getOne";//f

  constructor(
    private _httpClient: HttpClient, 
    private _loginService: LoginService) { }

  public getAll() {
    return this._httpClient.get<Array<Patient>>(this._url + "getAll");
  }
  
  //f-all
  
  public getAllForNurse(): Observable<Array<PatientForNurse>>
  {
    return this._httpClient.get<Array<PatientForNurse>>(this._url + "getAllForNurse");
  }

  public getOne(id : string): Observable<PatientForNurse>
  {
    return this._httpClient.get<PatientForNurse>(this._url + "getOne/" + id);
  }
  //*f-all

}
