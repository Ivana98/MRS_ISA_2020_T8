import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MedicalRoom } from 'src/app/model/medicalRoom';

@Injectable({
  providedIn: 'root'
})
export class MedicalRoomService {

  private _url: string = "http://localhost:8080/api/rooms/";

  constructor(private _httpClient: HttpClient) { }

  public addRoom(room) {
    return this._httpClient.post<MedicalRoom>(this._url + "save", room);
  }

  /*
  * get all medical rooms from specific clinic
  */
  public getAll(clinicId) {
    return this._httpClient.get<Array<MedicalRoom>>(this._url + "getAll/" + clinicId);
  }

  public modifyMedicalRoom(room) {
    return this._httpClient.put<MedicalRoom>(this._url + "modify", room);
  }

  public deleteMedicalRoom(id) {
    return this._httpClient.delete<Number>(this._url + "delete/" + id);
  }
}
