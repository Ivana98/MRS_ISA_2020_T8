import { Injectable } from '@angular/core';
import { Clinic, IClinic } from 'src/app/model/clinicToList';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransferClinicService {

  private clinic: Clinic = new Clinic(0, '', '', '', 0, [], false, 0, 0);
      //This is the key the Subject to transfer
  clinic$ = new BehaviorSubject<Clinic>(this.clinic);

  private clinicList : any = [];
  clinicList$ = new BehaviorSubject<[]>(this.clinicList);

  private clinicRow : number = 0;
  clinicRow$ = this.clinicRow;

  setClinic(cl: Clinic) {
    this.clinic$.next(cl);
  }

  setClinicList(clList: []){
    this.clinicList$.next(clList);
  }

  setClinicRow(rowNum: number){
    this.clinicRow$ = rowNum;
  }

  constructor() { }
}
