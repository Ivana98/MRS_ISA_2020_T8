import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from 'src/app/model/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private _url: string = "http://localhost:8080/api/patients/";

  constructor(private _httpClient: HttpClient) { }

  public getAll() {
    return this._httpClient.get<Array<Patient>>(this._url + "getAll");
  }
}
