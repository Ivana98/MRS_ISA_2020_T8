import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICLinicToDisplay } from 'src/app/model/clinic';

@Injectable({
  providedIn: 'root'
})
export class ClinicService {

  private _url: string = "http://localhost:8080/api/clinics/getAll";

  constructor(private _httpClient: HttpClient) { }

  /*
    return id and name of clinic 
  */
  public getAll(): Observable<Array<ICLinicToDisplay>>
  {
    return this._httpClient.get<Array<ICLinicToDisplay>>(this._url);
  }
}
