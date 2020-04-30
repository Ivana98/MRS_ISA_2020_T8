import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MedicalRoom } from 'src/app/model/medicalRoom';

@Injectable({
  providedIn: 'root'
})
export class MedicalRoomService {

  private _url: string = "http://localhost:8080/api/rooms/save";

  constructor(private _httpClient: HttpClient) { }

  public addRoom(room) {
    return this._httpClient.post<MedicalRoom>(this._url, room);
  }
}
