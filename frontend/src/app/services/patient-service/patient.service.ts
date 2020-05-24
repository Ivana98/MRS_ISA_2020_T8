import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from 'src/app/model/patient';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private _urlGetAll: string = "http://localhost:8080/api/patient/getAll";
  private _urlGetOne: string = "http://localhost:8080/api/patient/getOne";

  constructor(private _httpClient: HttpClient) { }

  /*
    return list of id and name of all clinics
  */
  public getAll(): Observable<Array<Patient>>
  {
    return this._httpClient.get<Array<Patient>>(this._urlGetAll);
  }

  public getOne(id : string): Observable<Patient>
  {
    return this._httpClient.get<Patient>(this._urlGetOne + "/" + id);
  }

}
