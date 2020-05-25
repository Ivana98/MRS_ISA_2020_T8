import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient, PatientForNurse } from 'src/app/model/patient';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private _url: string = "http://localhost:8080/api/patients/";

  private _urlGetAll: string = "http://localhost:8080/api/patient/getAllForNurse";//f
  private _urlGetOne: string = "http://localhost:8080/api/patient/getOne";//f

  constructor(private _httpClient: HttpClient) { }

  public getAll() {
    return this._httpClient.get<Array<Patient>>(this._url + "getAll");
  }
  

  
  //f-all
  
  public getAllForNurse(): Observable<Array<PatientForNurse>>
  {
    return this._httpClient.get<Array<PatientForNurse>>(this._urlGetAll);
  }

  public getOne(id : string): Observable<PatientForNurse>
  {
    return this._httpClient.get<PatientForNurse>(this._urlGetOne + "/" + id);
  }
  //*f-all

}
