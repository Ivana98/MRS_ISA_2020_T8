import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IClinic } from 'src/app/model/clinicToList';

@Injectable({
  providedIn: 'root'
})
export class ListClinicsService {
  
  private _ulrListForTable: string = "http://localhost:8080/api/clinics/sendListForTable";

  constructor(private _httpClient:HttpClient) {  }

  getListForTable()
  {
    return this._httpClient.get<IClinic[]>(this._ulrListForTable);
  }
}
