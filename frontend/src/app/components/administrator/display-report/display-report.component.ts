import { Component, OnInit, ViewChild, HostListener, ChangeDetectorRef } from '@angular/core';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';
import { DoctorForClinicList2 } from 'src/app/model/doctorForClinicList';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { StartEndDateClinicId } from 'src/app/model/StartEndDateClinicId';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';

@Component({
  selector: 'app-display-report',
  templateUrl: './display-report.component.html',
  styleUrls: ['./display-report.component.css']
})
export class DisplayReportComponent implements OnInit {

  showChart: boolean = false;

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

  startEndDateClinicId: StartEndDateClinicId = new StartEndDateClinicId(new Date(), new Date(),  1);

  income: number = -1;

  previous: any = [];
  searchText: string = ''; 
  previousearch: string;

  clinicAverageMark: number = 123;
  doctors: Array<DoctorForClinicList2> = [];

  constructor(
    private _httpClinicService: ClinicService,
    private _httpDoctorService: DoctorService,
    private _httpExaminaitonService: ExaminationService,
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


    // setTimeout(() => {

    //   this.chartDatasets= [
      
    //   { data: this.data2, label: this.label2 },
      
    //   { data: [], label: '' },
      
    //   ];
      
    //   }, 3000);
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
   * 
   */
  public loadIncomes() {
    this._httpClinicService.getIncome(this.startEndDateClinicId.startDate, this.startEndDateClinicId.endDate)
      .subscribe(data => {
        this.income = data;
      });
  }


  public dailyReportLoad() {
   
  }

  /**
   * 
   */
  public dailyReport() {

    var now = new Date();

    this._httpExaminaitonService.loadDailyExaminations(now)
      .subscribe(data => {

        // update chart
        this.chartDatasets = [
          { data: data, label: "Daily" },
          // { data: [], label: '' },
        ];

          this.showChart = true;  // show chart
      });

    // load list of last 24 hours
    this._httpExaminaitonService.get24HourList(now)
      .subscribe(data => {
        this.chartLabels = data;
      });
  }

  /**
   * 
   */
  public weeklyReport() {
    
    var now = new Date();

    this._httpExaminaitonService.loadWeeklyExaminations(now)
      .subscribe(data => {

        // update chart
        this.chartDatasets = [
          { data: data, label: "Weekly" },
          // { data: [], label: '' },
        ];

          this.showChart = true;  // show chart
      });

    // load list of last 7 days
    this._httpExaminaitonService.get7DaysList(now)
      .subscribe(data => {
        this.chartLabels = data;
      });
  }

  public annualReport() {
    
    var now = new Date();

    this._httpExaminaitonService.loadAnnualExaminations(now)
      .subscribe(data => {

        // update chart
        this.chartDatasets = [
          { data: data, label: "Annual" },
          // { data: [], label: '' },
        ];

          this.showChart = true;  // show chart
      });

    // load list of last 12 months
    this._httpExaminaitonService.get12MonthsList(now)
      .subscribe(data => {
        this.chartLabels = data;
      });
  }

  chartType: string = 'line';

  chartDatasets: Array<any> = [
    { data: [], label: 'My First dataset' }
  ];

  chartLabels: Array<any> = ['January', 'February', 'March', 'April', 'May', 'June', 'July'];

  chartColors: Array<any> = [
    {
      backgroundColor: 'rgba(105, 0, 132, .2)',
      borderColor: 'rgba(200, 99, 132, .7)',
      borderWidth: 2,
    }
  ];

  chartOptions: any = {
    responsive: true
  };
  chartClicked(e: any): void { }
  chartHovered(e: any): void { }

}
