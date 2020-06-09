import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { AbsenceService } from 'src/app/services/absence-service/absence.service';
import { Absence } from 'src/app/model/absence';
import { loadavg } from 'os';
import { AbsenceUser, AbsenceUserToDisplay } from 'src/app/model/absenceUser';
import { formatDate } from '@angular/common';
import { AbsenceRequest } from 'src/app/model/absenceRequest';

@Component({
  selector: 'app-absences',
  templateUrl: './absences.component.html',
  styleUrls: ['./absences.component.css']
})
export class AbsencesComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;

  previous: any = [];
  searchText: string = ''; 
  previousearch: string;

  userName: string = "";
  abType: string = "";
  abId: number = -1;
  choosenAbsence;

  absenceRequest: AbsenceRequest = new AbsenceRequest(-1, "");

  description: string = "";

  absences: Array<AbsenceUser> = [];
  absencesToDisplay: Array<AbsenceUserToDisplay> = [];

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpAbsenceService: AbsenceService
  ) { }

  @HostListener('input') oninput() { this.searchItems(); } 

  ngOnInit(): void {
    this.loadAbsences();
  }

  /**
   * Load all absences which are not confirmed or denied from clinic.
   */
  loadAbsences() {
    this._httpAbsenceService.getAllFromClinic()
      .subscribe(response => {
        this.setResponse(response);
      });
  }

  /**
   * When click on row
   * 
   * @param data is row element
   */
  getRow(data) {
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

  /**
   * createing new list of absences, where date is formated string. 
   * 
   * @param response is list of absences
   */
  setResponse(response){
    this.absences = response;

    response.forEach(absence => {
      var dateB = absence.beginDate;  // begin date
      var dateE = absence.endDate;  // end date

      var formattedDateB = formatDate(dateB, 'dd.MM.yyyy. HH:mm', 'en-US');  // begin formatted date
      var formattedDateE = formatDate(dateE, 'dd.MM.yyyy. HH:mm', 'en-US');  // end formatted date

      if (absence.absenceType == "VACATION") absence.absenceType = "Vacation";
      else absence.absenceType = "Sick leave";
      
      // create new absence and add to other list
      var absenceDisplay = new AbsenceUserToDisplay(absence.id, formattedDateB, formattedDateE, absence.absenceType, absence.confirmed, absence.userId, absence.firstName, absence.lastName, absence.email);
      this.absencesToDisplay.push(absenceDisplay);
    });

    // this.mdbTable.setDataSource(this.absences);
    // this.absences = this.mdbTable.getDataSource();
    // this.previous = this.mdbTable.getDataSource();
    // this.previousearch = this.mdbTable.getDataSource(); 
    this.setTable();
  }

  setTable() {
    this.mdbTable.setDataSource(this.absences);
    this.absences = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.absences = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.absences = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

  /**
   * Confirm absence.
   */
  confirm() {
    this._httpAbsenceService.confirm(this.abId)
      .subscribe(response => {

        // delete absence from table
        this.absences.forEach( (item, index) => {
          if(item.id === response.id) this.absences.splice(index,1);
        });

        this.absencesToDisplay.forEach( (item, index) => {
          if(item.id === response.id) this.absences.splice(index,1);
        });

        alert("You are successfuly confirmed absence.");

        this.setTable();
      });
  }

  /**
   * Deny absence, with description why is absence denied.
   */
  deny() {
    this._httpAbsenceService.deny(this.absenceRequest)
      .subscribe(response => {

        // delete absence from table
        this.absences.forEach( (item, index) => {
          if(item.id === response.id) this.absences.splice(index,1);
        });

        this.absencesToDisplay.forEach( (item, index) => {
          if(item.id === response.id) this.absences.splice(index,1);
        });

        alert("You are successfuly denied absence.");

        this.setTable();
      });
  }

  /**
   * Take absence type and user name of choosen absence, for popun display purpose.
   * Also remember absence id.
   * 
   * @param data is absence
   */
  takeData(data) {
    this.userName = data.firstName + " " + data.lastName;
    if (data.absenceType == "VACATION") this.abType = "vacation";
    else this.abType = "sick leave";

    this.abId = data.id;

    this.absenceRequest.id = data.id;

    this.absences.forEach( (item, index) => {
      if(item.id === data.id) this.choosenAbsence = item;
    });

    console.log("Ajmo sad: " + this.choosenAbsence.id);
    
  }

}
