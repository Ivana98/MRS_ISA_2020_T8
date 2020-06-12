import { Injectable } from '@angular/core';
import { Patient } from 'src/app/model/patient';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransferPatientService {

  private patient: Patient = new Patient(-1, "","","","","","","","","","","","","","","");
      //This is the key the Subject to transfer
  patient$ = new BehaviorSubject<Patient>(this.patient);

  setPatient(cl: Patient) {
    this.patient$.next(cl);
  }

  constructor() { }
}
