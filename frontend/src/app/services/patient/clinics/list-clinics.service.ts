import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IClinic } from 'src/app/model/clinicToList';
import { ApiService } from '../../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class ListClinicsService {
  
  private _ulrListForTable: string = "http://localhost:8080/api/clinics/sendListForTable";

  constructor(private _httpClient:HttpClient, private _apiService: ApiService) {  }

  getListForTable()
  {
    //return this._httpClient.get<IClinic[]>(this._ulrListForTable);
    return this._apiService.get(this._ulrListForTable, this._apiService.headers);
  }
}
