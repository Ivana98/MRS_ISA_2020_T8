import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
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
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;
  
  previous: any = [];
  searchText: string = ''; 
  previousearch: string;

  patientsList: Array<Patient> = [];
  patientDisplay: Patient = new Patient(-1, "","","","","","","","","","","","","","","");

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpPatientService: PatientService
    // private _someLogic: PatientShareService
  ) { }

  @HostListener('input') oninput() { this.searchItems(); } 

  ngOnInit(): void {
    this.loadPatients();
  }

  loadPatients() {
    this._httpPatientService.getAll().subscribe(response => this.setResponse(response))
  }

  /**
   * Take data of choosen patient.
   * 
   * @param data is choosen patient
   */
  getRow(data) {
    this.patientDisplay = data;
  }

  ngAfterViewInit() {
    this.pagination();
  }

  pagination() {
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
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.patientsList = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.patientsList = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

}
