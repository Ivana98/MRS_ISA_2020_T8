import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IMedicalRecords } from 'src/app/model/medicalRecords';

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordsService {

  private _ulrMedicalRecords: string = "http://localhost:8080/api/patient/sendMedicalRecords";

  constructor(private _httpClient:HttpClient) {  }

  getMedicalRecords()
  {
    return this._httpClient.get<IMedicalRecords>(this._ulrMedicalRecords);
  }
}
