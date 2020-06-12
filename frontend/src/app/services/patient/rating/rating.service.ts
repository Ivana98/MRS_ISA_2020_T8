import { Injectable } from '@angular/core';
import { ApiService } from '../../api-services/api.service';
import { SaveMark } from 'src/app/model/saveMark';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  //private _ulrDoctorRate: string = "http://localhost:8080/api/clinics/sendListForTable";
  private _ulrClinicRate: string = "http://localhost:8080/api/clinics/saveClinicMark";

  constructor(private _apiService: ApiService) {  }

  setClinicRate(saveMark : SaveMark)
  {
    return this._apiService.post(this._ulrClinicRate, saveMark, this._apiService.headers);
  }
}
