import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { ListClinicsService } from 'src/app/services/patient/clinics/list-clinics.service';
import { PatientService } from 'src/app/services/patient-service/patient.service';
@Component({
  selector: 'app-table-of-patient',
  templateUrl: './table-of-patient.component.html',
  styleUrls: ['./table-of-patient.component.css']
})
export class TableOfPatientComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective
  patientList: any = [];
  previous: any = [];

  constructor(private _patientService: PatientService, private cdRef: ChangeDetectorRef) { 
    //console.log("PA TU SAM!");

  }

  ngOnInit(): void {
    this._patientService.getAll().subscribe(response => this.setResponse(response));
  }
  

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);

    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }
  setResponse(p){
    console.log(p);
    this.patientList = p;
    this.mdbTable.setDataSource(this.patientList);
    this.patientList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
  }

}
