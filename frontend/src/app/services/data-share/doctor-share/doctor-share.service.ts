import { Injectable } from '@angular/core';
import { Doctor } from 'src/app/model/doctor';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorShareService {

  private _doctor = new Subject<Doctor>();
  _userDoc$ = this._doctor.asObservable();

  private _loadDoctor = new Subject<Array<Doctor>>();
  _userLoad$ = this._loadDoctor.asObservable();

  sendDoctor(message: Doctor) {
    this._doctor.next(message);
  }

  loadDoctorsAgain(message: Array<Doctor>) {
    this._loadDoctor.next(message)
  }

  constructor() { }
}
