import { Component, OnInit } from '@angular/core';
import { IMedicalRecords, MedicalRecords } from 'src/app/model/medicalRecords';
import { MedicalRecordsService } from 'src/app/services/patient/medical-records/medical-records.service';

@Component({
  selector: 'app-medical-records',
  templateUrl: './medical-records.component.html',
  styleUrls: ['./medical-records.component.css']
})
export class MedicalRecordsComponent implements OnInit {
  records : IMedicalRecords = new MedicalRecords("", "", "", 0, 0, "", "", "");

  constructor(
    private _httpRecordsService: MedicalRecordsService
  ) { }

  ngOnInit(): void {
    this._httpRecordsService.getMedicalRecords().subscribe(response => this.records = response);
  }

}
