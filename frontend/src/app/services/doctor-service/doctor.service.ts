import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor } from 'src/app/model/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private _url: string = "http://localhost:8080/api/doctors/";

  constructor(private _httpClient: HttpClient) { }

  public addDoctor(doctor) {
    return this._httpClient.post<Doctor>(this._url + "save", doctor);
  }

  public getDoctors() {
    return this._httpClient.get<Array<Doctor>>(this._url + "getAll");
  }

  public getAllByClinic(clinicId) {
    return this._httpClient.get<Array<Doctor>>(this._url + "getAllByClinic/" + clinicId);
  }

  public modifyDoctor(doctor) {
    return this._httpClient.put<Doctor>(this._url + "modify", doctor);
  }

  public deleteDoctor(id) {
    return this._httpClient.delete<Number>(this._url + "delete/" + id);
  }
}
