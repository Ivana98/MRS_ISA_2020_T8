import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener, ElementRef } from '@angular/core';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { Patient } from 'src/app/model/patient';
import { PatientService } from 'src/app/services/patient-service/patient.service';
import { MedicalRecordExamination } from 'src/app/model/medicalRecordExamination';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';

@Component({
  selector: 'app-display-patients',
  templateUrl: './display-patients.component.html',
  styleUrls: ['./display-patients.component.css']
})
export class DisplayPatientsComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;
  
  isMedicalRecordShown: boolean = false;
  canSeeMedicalRecord: Boolean = true;
  canDoExamination: boolean = true;
  showMedRecButtonTxt: string = "Show medical record"
  
  // for patients
  previous: any = [];
  searchText: string = ''; 
  previousearch: string = '';

  patientsList: Array<Patient> = [];
  examinations: Array<MedicalRecordExamination> = [];

  patientDisplay: Patient = new Patient(-1, "","","","","","","","","","","","","","","");
  medRecExam: MedicalRecordExamination = new MedicalRecordExamination(-1, null, "", "", -1 ,"", "", "", null, null, null);

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpPatientService: PatientService,
    private _httpExaminationService: ExaminationService
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
   * Check if doctor can see medical record of patient. If can, enable button.
   * 
   * @param data is choosen patient
   */
  getRow(data) {
    this.patientDisplay = data;

    this._httpExaminationService.checkIfDoctorCanOpenMedicalRecord(this.patientDisplay.id)
      .subscribe(data => {
        this.canSeeMedicalRecord = !data;

        if (data == true) {
          this._httpExaminationService.loadPatientExaminations(this.patientDisplay.id)
            .subscribe(response => {
              this.examinations = response;
            });

          console.log("Moze da vidi karton.");
        } else console.log("Ovaj doktor NE moze da vidi karton.");

        this._httpExaminationService.canDoctorExaminate(this.patientDisplay.id)
          .subscribe(response => {
            this.canDoExamination = !response;
          });

      });
  }

  /**
   * On click save medical record examination.
   * 
   * @param data is medical record examination
   */
  getRow2(data) {
    this.medRecExam = data;
  }

  /**
   * 
   * @param data is prescription
   */
  getRow3(data) {

  }

  /**
   * 
   * @param data is disease
   */
  getRow4(data) {

  }

  openMedicalRecord() {

    // Show and hide medical records
    if (this.isMedicalRecordShown == false) {
      this.isMedicalRecordShown = true;
      this.showMedRecButtonTxt = "Hide medical record";
    } else {
      this.isMedicalRecordShown = false;
      this.showMedRecButtonTxt = "Show medical record";
    }

  }

  ngAfterViewInit() {
    this.pagination();

    this.cdRef.detectChanges();
  }

  pagination() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
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

  startExamination() {
    //TODO:

    
  }

}
