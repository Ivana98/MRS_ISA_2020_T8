import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExaminationType } from 'src/app/model/examinationType';

@Injectable({
  providedIn: 'root'
})
export class ExaminationTypeService {

  private _url: string = "http://localhost:8080/api/examinationTypes/";

  constructor(private _httpClient: HttpClient) { }

  public addExaminationType(exType) {
    return this._httpClient.post<ExaminationType>(this._url + "save", exType);
  }

  /**
   * Ovo mislim da nece trebati na ovakav nacin, tkd ce se verovatno brisati.
   */
  public getAll() {
    return this._httpClient.get<Array<ExaminationType>>(this._url + "getAll");
  }
}
