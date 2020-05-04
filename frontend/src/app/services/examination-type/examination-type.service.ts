import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExaminationType } from 'src/app/model/examinationType';

@Injectable({
  providedIn: 'root'
})
export class ExaminationTypeService {

  private _url: string = "http://localhost:8080/api/examinationTypes/save";

  constructor(private _httpClient: HttpClient) { }

  public addExaminationType(exType) {
    return this._httpClient.post<ExaminationType>(this._url, exType);
  }
}
