import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener, ElementRef } from '@angular/core';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { Patient } from 'src/app/model/patient';
import { PatientService } from 'src/app/services/patient-service/patient.service';
import { MedicalRecordExamination, MedicalRecordExamination2 } from 'src/app/model/medicalRecordExamination';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';
import { TransferPatientService } from 'src/app/services/transfer-patient-service/transfer-patient.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login-service/login.service';
import { formatDate } from '@angular/common';

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
  examinations2: Array<MedicalRecordExamination2> = [];

  patientDisplay: Patient = new Patient(-1, "","","","","","","","","","","","","","","");
  medRecExam: MedicalRecordExamination = new MedicalRecordExamination(-1, null, "", "", -1 ,"", "", "", null, null, null);

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpPatientService: PatientService,
    private _httpExaminationService: ExaminationService,
    private _transferService: TransferPatientService,
    private _router: Router,
    private _loginService: LoginService
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

    // take clicked patient
    this.patientDisplay = data;

    this._httpExaminationService.checkIfDoctorCanOpenMedicalRecord(this.patientDisplay.id)
      .subscribe(data => {
        this.canSeeMedicalRecord = !data;

        if (data == true) {
          this.loadPatientExaminations();

          this.canDoctorExaminatePatient();

          console.log("Moze da vidi karton.");
        } 
        else if (this._loginService.currentUser.userAuthority == "ROLE_CLINIC_ADMIN") {
          console.log("U pitanju je admin i moze da vidi karton");
          this.loadPatientExaminations();
          this.canSeeMedicalRecord = false;
        } 
        else console.log("Ovaj doktor NE moze da vidi karton.");

      });
  }

  /**
   * Check if doctor can examinate chosen patient.
   */
  canDoctorExaminatePatient() {
    this._httpExaminationService.canDoctorExaminate(this.patientDisplay.id)
      .subscribe(response => {
        this.canDoExamination = !response;
      });
  }

  /**
   * Load examinations of chosen patient.
   * 
   * @param patientId 
   */
  loadPatientExaminations() {
    this._httpExaminationService.loadPatientExaminations(this.patientDisplay.id)
      .subscribe(response => {
        this.examinations = response;
        this.setExaminations2(response);
      });
  }

  /**
   * 
   * @param exams 
   */
  setExaminations2(exams) {
    // napravi examinations 2.

    exams.forEach(exam => {
      var dateB = exam.date;  // begin date

      var formattedDate = formatDate(dateB, 'dd.MM.yyyy. HH:mm', 'en-US');  // begin formatted date

      var bioNaPregledu = "";

      if (exam.wasOnExamination) {
        bioNaPregledu = "Yes";
      } else {
        bioNaPregledu = "No";
      }
      
      // create new absence and add to other list
      var examDisplay = new MedicalRecordExamination2(exam.id, formattedDate, exam.specialisation, exam.interventionType, exam.staticPrice, exam.doctorName, exam.doctorSurname, exam.roomNumber, bioNaPregledu, exam.diseases, exam.prescriptions);
      this.examinations2.push(examDisplay);
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

  /**
   * Send data to other component.
   */
  startExamination() {
    this._transferService.setPatient(this.patientDisplay);
    this._router.navigate(['/user-page/start-examination']);
    
  }

}
