import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICLinicToDisplay } from 'src/app/model/clinic';

@Injectable({
  providedIn: 'root'
})
export class ClinicService {

  private _url: string = "http://localhost:8080/api/clinics/sendListForTable";

  constructor(private _httpClient: HttpClient) { }

  /*
    return list of id and name of all clinics
  */
  public getAll(): Observable<Array<ICLinicToDisplay>>
  {
    return this._httpClient.get<Array<ICLinicToDisplay>>(this._url);
  }
}
