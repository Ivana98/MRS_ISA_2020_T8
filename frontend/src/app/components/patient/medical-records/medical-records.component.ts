import { Component, OnInit } from '@angular/core';
import { IMedicalRecords, MedicalRecords } from 'src/app/model/medicalRecords';
import { MedicalRecordsService } from 'src/app/services/patient/medical-records/medical-records.service';
import { isNull } from 'util';

@Component({
  selector: 'app-medical-records',
  templateUrl: './medical-records.component.html',
  styleUrls: ['./medical-records.component.css']
})
export class MedicalRecordsComponent implements OnInit {
  records : IMedicalRecords = new MedicalRecords("", "", "", 0, 0, "", [], "");
  error: boolean;

  constructor(
    private _httpRecordsService: MedicalRecordsService
  ) { }

  ngOnInit(): void {
    this.error = false;
    this._httpRecordsService.getMedicalRecords().subscribe(response => {
      if(response !== null){
        this.records = response
      }
      else{
        this.error = true;
      }
    });
  }

}
