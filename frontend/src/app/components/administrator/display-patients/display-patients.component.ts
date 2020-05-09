import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { Patient } from 'src/app/model/patient';
import { PatientService } from 'src/app/services/patient-service/patient.service';

@Component({
  selector: 'app-display-patients',
  templateUrl: './display-patients.component.html',
  styleUrls: ['./display-patients.component.css']
})
export class DisplayPatientsComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective
  patientsList: Array<Patient> = [];
  previous: any = [];

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpPatientService: PatientService
    // private _someLogic: PatientShareService
  ) { }

  ngOnInit(): void {
    this.loadDoctors();
  }

  loadDoctors() {
    this._httpPatientService.getAll().subscribe(response => this.setResponse(response))
  }

  getRow(data) {
    // this._someLogic.sendDoctor(data);
    // this._someLogic.loadDoctorsAgain(this.patientsList);
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);

    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  setResponse(response){
    this.patientsList = response;
    this.mdbTable.setDataSource(this.patientsList);
    this.patientsList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
  }

}
