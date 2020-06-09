import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
import { IMedicalRecords, MedicalRecords } from 'src/app/model/medicalRecords';
import { MedicalRecordsService } from 'src/app/services/patient/medical-records/medical-records.service';
import { isNull } from 'util';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { ExaminationForPatient } from 'src/app/model/examinationForPatient';
import { IExamination } from 'src/app/model/examination';

@Component({
  selector: 'app-medical-records',
  templateUrl: './medical-records.component.html',
  styleUrls: ['./medical-records.component.css']
})
export class MedicalRecordsComponent implements OnInit {
  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;
  @HostListener('input') oninput() { this.searchItems(); }

  records : IMedicalRecords = new MedicalRecords("", "", "", 0, 0, "", "", "", []);
  date : Date;
  selectedExamination = new ExaminationForPatient(this.date, false, "", "", "", "", "", [], []);
  error: boolean;
  examinationsList: any = [];
  previous: any = []; //pagination variable
  searchText: string = '';
  previousearch: string; //search variable

  constructor(
    private _httpRecordsService: MedicalRecordsService, private cdRef: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.error = false;
    this._httpRecordsService.getMedicalRecords().subscribe(response => {
      if(response !== null){
        this.records = response
        this.examinationsList = this.records.examinations;

        //set table
        this.mdbTable.setDataSource(this.examinationsList);
        this.examinationsList = this.mdbTable.getDataSource();
        this.previous = this.mdbTable.getDataSource();
        this.previousearch = this.mdbTable.getDataSource();
      }
      else{
        this.error = true;
      }
    });
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  searchItems() {
    const prev = this.mdbTable.getDataSource();

    if (!this.searchText) {
      this.mdbTable.setDataSource(this.previousearch);
      this.examinationsList = this.mdbTable.getDataSource();
    }
    if (this.searchText) {
      this.examinationsList = this.mdbTable.searchLocalDataBy(this.searchText);
      this.mdbTable.setDataSource(prev);
    }
  }

  rowSelected(examination : ExaminationForPatient){
    this.selectedExamination = examination;
  }

}
