import { Component, OnInit, ViewChild, HostListener, ChangeDetectorRef } from '@angular/core';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';
import { DoctorForClinicList2 } from 'src/app/model/doctorForClinicList';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { StartEndDateClinicId } from 'src/app/model/StartEndDateClinicId';

@Component({
  selector: 'app-display-report',
  templateUrl: './display-report.component.html',
  styleUrls: ['./display-report.component.css']
})
export class DisplayReportComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

  startEndDateClinicId: StartEndDateClinicId = new StartEndDateClinicId(new Date(), new Date(),  1);

  income;

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

  private loadDoctors() {
    this._httpDoctorService.getAllByClinicForAverageMark()
      .subscribe(data => {
        this.setResponse(data);
      })
  }

  ngAfterViewInit() {
    this.pagination();
  }

  private pagination() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(6);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  private setResponse(response){
    this.doctors = response;
    this.mdbTable.setDataSource(this.doctors);
    this.doctors = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  private searchItems(){
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

  private loadClinicAverageMark() {
    this._httpClinicService.getClinicAverageMark()
      .subscribe(mark => {
        this.clinicAverageMark = mark;
      });
  }

  /**
   * 
   * @param data 
   */
  public getRow(data) {

  }

  /**
   * 
   * @param event is choosen date
   */
  public onStartDate(event): void {
    this.startEndDateClinicId.startDate = event;
    console.log("Datum 1: " + this.startEndDateClinicId.startDate);
  }

  /**
   * 
   * @param event is choosen date
   */
  public onEndDate(event): void {
    this.startEndDateClinicId.endDate = event;
    console.log("Datum 2: " + this.startEndDateClinicId.endDate);
  }

  /**
   * Ne radi ne znam zasto... ali na beku
   */
  public loadIncomes() {
    // console.log("start date: " + this.startEndDateClinicId.startDate)
    // console.log("  end date: " + this.startEndDateClinicId.endDate)
    this._httpClinicService.getIncome(this.startEndDateClinicId)
      .subscribe(data => {
        console.log("IDEMOOOO: "+data);
        // this.income = data;
      });
  }

  public chartType: string = 'bar';

  public chartDatasets: Array<any> = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'My First dataset' }
  ];

  public chartLabels: Array<any> = ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'];

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)'
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)'
      ],
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }

}
