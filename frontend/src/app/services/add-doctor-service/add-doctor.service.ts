import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor2 } from 'src/app/model/doctor';

@Injectable({
  providedIn: 'root'
})
export class AddDoctorService {

  private _url: string = "http://localhost:8080/api/doctors/save";

  constructor(private _httpClient: HttpClient) { }

  public addDoctor(doctor) {
    return this._httpClient.post<Doctor2>(this._url, doctor);
  }
}
