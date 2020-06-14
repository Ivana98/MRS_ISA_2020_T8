import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor } from 'src/app/model/doctor';
import { LoginService } from '../login-service/login.service';
import { DoctorForClinicList2 } from 'src/app/model/doctorForClinicList';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  private _url: string = "http://localhost:8080/api/doctors/";

  constructor(
    private _httpClient: HttpClient, 
    private _loginService: LoginService
  ) { }

  /**
   * 
   * @param doctor 
   */
  public addDoctor(doctor) {
    return this._httpClient.post<Doctor>(this._url + "save", doctor);
  }

  /**
   * 
   */
  public getDoctors() {
    return this._httpClient.get<Array<Doctor>>(this._url + "getAll");
  }

  /**
   * 
   */
  public getAllByClinic() {
    return this._httpClient.get<Array<Doctor>>(this._url + "getAllByClinic/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Get all doctors from clinic, with purpose to display average mark.
   */
  public getAllByClinicForAverageMark() {
    return this._httpClient.get<Array<DoctorForClinicList2>>(this._url + "getAllByClinicForAverageMark/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Update doctor.
   * 
   * @param doctor 
   */
  public modifyDoctor(doctor) {
    return this._httpClient.put<Doctor>(this._url + "modify", doctor);
  }

  /**
   * Delete doctor with id.
   * 
   * @param id is doctor id
   */
  public deleteDoctor(id) {
    return this._httpClient.delete<Number>(this._url + "delete/" + id);
  }

  /**
   * Return true if doctor has appointments in future.
   * 
   * @param doctorId 
   */
  public checkIfDoctorHasAppointments(doctorId) {
    return this._httpClient.get<boolean>(this._url + "checkIfDoctorHasAppointments/" + doctorId);
  }
}
