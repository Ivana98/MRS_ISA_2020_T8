import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IClinic } from 'src/app/model/clinicToList';
import { ApiService } from '../../api-services/api.service';
import { FilterClinicsClass } from 'src/app/model/searchFilterClinics';

@Injectable({
  providedIn: 'root'
})
export class ListClinicsService {
  
  private _ulrListForTable: string = "http://localhost:8080/api/clinics/sendListForTable";
  private _ulrFilterClinics: string = "http://localhost:8080/api/clinics/filterClinics";
  private _urlOfferedAppointments = "http://localhost:8080/api/clinics/offeredAppointments";

  constructor(private _httpClient:HttpClient, private _apiService: ApiService) {  }

  getListForTable()
  {
    return this._apiService.get(this._ulrListForTable, this._apiService.headers);
  }

  getFilteredClinics(filterCl : FilterClinicsClass)
  {
    return this._apiService.post(this._ulrFilterClinics, filterCl, this._apiService.headers);
  }

  getClinicAppointments(clinicId : number){
    return this._apiService.post(this._urlOfferedAppointments, JSON.stringify(clinicId), this._apiService.headers);
  }
}
