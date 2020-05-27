import { Component, OnInit, ViewChild, HostListener, ChangeDetectorRef } from '@angular/core';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';
import { DoctorForClinicList2 } from 'src/app/model/doctorForClinicList';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';

@Component({
  selector: 'app-display-report',
  templateUrl: './display-report.component.html',
  styleUrls: ['./display-report.component.css']
})
export class DisplayReportComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

  startDate: Date;
  endDate: Date;

  previous: any = [];
  searchText: string = ''; 
  previousearch: string;

  clinicAverageMark: number = 123;
  doctors: Array<DoctorForClinicList2> = [];

  constructor(
    private _httpClinicService: ClinicService,
    private _httpDoctorService: DoctorService,
    private cdRef: ChangeDetectorRef,
  ) { }

  @HostListener('input') oninput() { this.searchItems(); } 

  ngOnInit(): void {
    this.loadClinicAverageMark();
    this.loadDoctors();
  }

  loadDoctors() {
    this._httpDoctorService.getAllByClinicForAverageMark()
      .subscribe(data => {
        this.setResponse(data);
      })
  }

  ngAfterViewInit() {
    this.pagination();
  }

  pagination() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(6);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  setResponse(response){
    this.doctors = response;
    this.mdbTable.setDataSource(this.doctors);
    this.doctors = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.doctors = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.doctors = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

  loadClinicAverageMark() {
    this._httpClinicService.getClinicAverageMark()
      .subscribe(mark => {
        this.clinicAverageMark = mark;
      });
  }

  getRow(data) {

  }

  /**
   * 
   * @param event is choosen date
   */
  public onStartDate(event): void {
    this.startDate = event;
    console.log("Datum 1: " + this.startDate);
  }

  /**
   * 
   * @param event is choosen date
   */
  public onEndDate(event): void {
    this.endDate = event;
    console.log("Datum 2: " + this.endDate);
  }

}
