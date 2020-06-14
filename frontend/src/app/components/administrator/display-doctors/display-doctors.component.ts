import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { MdbTableDirective, MdbTablePaginationComponent } from 'angular-bootstrap-md';
import { ListClinicsService } from 'src/app/services/patient/clinics/list-clinics.service';
import { Router } from '@angular/router';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { DoctorShareService } from 'src/app/services/data-share/doctor-share/doctor-share.service';
import { Doctor } from 'src/app/model/doctor';
import { ChangeDoctorComponent } from 'src/app/components/administrator/change-doctor/change-doctor.component';
import { LoginService } from 'src/app/services/login-service/login.service';

@Component({
  selector: 'app-display-doctors',
  templateUrl: './display-doctors.component.html',
  styleUrls: ['./display-doctors.component.css']
})
export class DisplayDoctorsComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

  doctorsList: Array<Doctor> = [];
  previous: any = [];

  searchText: string = ''; 
  previousearch: string; //search variable

  showChangeDoctor: boolean = false;

  constructor(
    private cdRef: ChangeDetectorRef, public router: Router,
    private _httpDoctorService: DoctorService,
    private _someLogic: DoctorShareService,
    private _router: Router
    ) 
  { }

  @HostListener('input') oninput() { this.searchItems();} 

  ngOnInit(): void {
    this.loadDoctors();
  }

  loadDoctors() {
    this._httpDoctorService.getAllByClinic().subscribe(response => this.setResponse(response))
  }

  goToAddDoctorPage() {
    this._router.navigate(['/user-page/addDoctor']);
  }

  getRow(data) {
    this._someLogic.sendDoctor(data);
    this._someLogic.loadDoctorsAgain(this.doctorsList);
    this.showChangeDoctor = true;
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);

    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  setResponse(r){
    this.doctorsList = r;
    this.mdbTable.setDataSource(this.doctorsList);
    this.doctorsList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.doctorsList = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.doctorsList = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

}
