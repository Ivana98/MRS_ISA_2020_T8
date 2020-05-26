import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MedicalRoom } from 'src/app/model/medicalRoom';
import { LoginService } from '../login-service/login.service';

@Injectable({
  providedIn: 'root'
})
export class MedicalRoomService {

  private _url: string = "http://localhost:8080/api/rooms/";

  constructor(private _httpClient: HttpClient, private _loginService: LoginService) { }

  public addRoom(room) {
    return this._httpClient.post<MedicalRoom>(this._url + "save", room);
  }

  /** 
   * get all medical rooms from specific clinic.
   * 
   * @param clinicId is id of clinic
   */
  public getAll(clinicId) {
    return this._httpClient.get<Array<MedicalRoom>>(this._url + "getAll/" + clinicId);
  }

  /**
   * Get all medical rooms by intervetnion type examination from specific clinic.
   */
  public getAllByExamination() {
    return this._httpClient.get<Array<MedicalRoom>>(this._url + "getAllByExamination/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Save modifications of medical room.
   * 
   * @param room is modified MedicalRoom with same ID
   */
  public modifyMedicalRoom(room) {
    return this._httpClient.put<MedicalRoom>(this._url + "modify", room);
  }

  /**
   * Delete medical room by ID.
   * Checking on server if there is operation or examination in current time or future.
   * 
   * @param id is ID of MedicalRoom which we want to delete
   */
  public deleteMedicalRoom(id) {
    return this._httpClient.delete(this._url + "delete/" + id);
  }

  /**
   * get medical room by id.
   * 
   * @param id is MedicalRoom ID
   */
  public getOne(id) {
    return this._httpClient.get<MedicalRoom>(this._url + "getOne/" + id);
  }

}
