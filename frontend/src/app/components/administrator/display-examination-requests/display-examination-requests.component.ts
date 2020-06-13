import { Component, OnInit, ViewChild, HostListener, ChangeDetectorRef } from '@angular/core';
import { MdbTableDirective, MdbTablePaginationComponent } from 'angular-bootstrap-md';
import { ExaminationRequestDisplay, ExaminationRequestDisplay2, ApprovedExaminationRequest } from 'src/app/model/examinationRequest';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';
import { formatDate } from '@angular/common';
import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';
import { MedicalRoom } from 'src/app/model/medicalRoom';

@Component({
  selector: 'app-display-examination-requests',
  templateUrl: './display-examination-requests.component.html',
  styleUrls: ['./display-examination-requests.component.css']
})
export class DisplayExaminationRequestsComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;

  previous: any = [];
  searchText: string = ''; 
  previousearch: string;

  examinations: Array<ExaminationRequestDisplay> = [];
  examinations2: Array<ExaminationRequestDisplay2> = [];
  choosenRequestedExamination: ExaminationRequestDisplay2 = new ExaminationRequestDisplay2(-1, -1, -1, "", "", "", -1, "", "", "", "");
  approvedRequestedExamination: ApprovedExaminationRequest = new ApprovedExaminationRequest(-1, -1, -1, null);

  freeRooms: Array<MedicalRoom> = [];
  choosenRoom: MedicalRoom = new MedicalRoom(-1, "", "", -1);

  showRooms: boolean = false;
  showDateAndTime: boolean = true;
  canApprove: boolean = false;

  date = new Date();
  time: string;
  /*
    this.date.setHours(Number(this.time.substring(0,2)));
    this.date.setMinutes(Number(this.time.substring(3,5)));
    this.date.setSeconds(0);
   */

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpExaminationService: ExaminationService,
    private _httpMedicalRoomService: MedicalRoomService
  ) { }

  @HostListener('input') oninput() { this.searchItems(); } 

  ngOnInit(): void {
    this.setResponse(this.examinations);
    this.loadExaminations();
  }

  loadExaminations() {
    this._httpExaminationService.loadAllExaminationRequest()
      .subscribe(response => {
        this.setResponse(response);
      });
  }

  /**
   * Find free rooms
   * 
   * @param data is ExaminationRequestDisplay2
   */
  getRow(data) {
    this.choosenRequestedExamination = data;
    this.approvedRequestedExamination.newDate = null;
    
    this.findFreeRooms();
  }

  findFreeRooms() {
    this._httpMedicalRoomService.findFreeRoomsForExaination(this.choosenRequestedExamination.id)
      .subscribe(data => {
        this.freeRooms = data;
        if (data.length == 0) this.showDateAndTime = true;
        else this.showDateAndTime = false;
      });

    this.showRooms = true;
  }

  /**
   * 
   */
  changeDate() {
    this.approvedRequestedExamination.newDate = this.date;
    this.findFreeRoomsNewDate();
  }

  /**
   * 
   */
  findFreeRoomsNewDate() {
    this.date.setHours(Number(this.time.substring(0,2)));
    this.date.setMinutes(Number(this.time.substring(3,5)));
    this.date.setSeconds(0);

    this._httpMedicalRoomService.findFreeRoomsForExainationAndNewDate(this.choosenRequestedExamination.id, this.date)
      .subscribe(data => {
        this.freeRooms = data;
        if (data.length == 0) this.showDateAndTime = true;
        else this.showDateAndTime = false;
      });
  }

  /**
   * 
   * @param data 
   */
  getRow2(data) {
    this.choosenRoom = data;
    this.canApprove = true;
  }

  /**
   * Approve examination request.
   */
  approve() {
    this.approvedRequestedExamination.id = this.choosenRequestedExamination.id;
    this.approvedRequestedExamination.medicalRoomId = this.choosenRoom.id;

    this._httpExaminationService.approveRequestedExamination(this.approvedRequestedExamination)
      .subscribe(response => {
        if (response == true) alert("You successfuly approved examination request.");
        else alert("Something is wrong.");
      });
  }

  /**
   * Deny examination request.
   */
  deny() {
    this._httpExaminationService.denyRequestedExamination(this.choosenRequestedExamination)
      .subscribe(response => {
        if (response == true) alert("You successfuly denied examination request.");
        else alert("Something is wrong.");
      });
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

    this.examinations = response;

    response.forEach(e => {
      var date = e.date;
      console.log(e.patientName);

      var formattedDate = formatDate(date, 'dd.MM.yyyy. HH:mm', 'en-US');
      
      var e2 = new ExaminationRequestDisplay2(-1, -1, -1, "", "", "", -1, "", "", "", "");
      
      e2.id = e.id; 
      e2.clinicId = e.clinicId;
      e2.doctorId = e.doctorId;
      e2.doctorName = e.doctorName;
      e2.doctorSurname = e.doctorSurname;
      e2.doctorSpecialisation = e.doctorSpecialisation;
      e2.patientId =  e.patientId;
      e2.patientName = e.patientName;
      e2.patientSurname = e.patientSurname;
      e2.interventionType =e.interventionType;
      e2.patientName = e.patientName;
      e2.date = formattedDate;

      this.examinations2.push(e2);
    });
    
    this.mdbTable.setDataSource(this.examinations2);
    this.examinations2 = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.examinations = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.examinations = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

}
