import { Component, OnInit, ChangeDetectorRef, ViewChild } from '@angular/core';
import { TransferClinicService } from 'src/app/services/patient/clinics/transfer-clinic.service';
import { ListClinicsService } from 'src/app/services/patient/clinics/list-clinics.service';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { ExaminationRequest } from 'src/app/model/examinationRequest';
import { LoginService } from 'src/app/services/login-service/login.service';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';
import { OfferedAppointmentClass } from 'src/app/model/offeredAppointments';

@Component({
  selector: 'app-offered-appointments',
  templateUrl: './offered-appointments.component.html',
  styleUrls: ['./offered-appointments.component.css']
})
export class OfferedAppointmentsComponent implements OnInit {

  clinic: any;
  clinicName = "";
  examinationsList : any = [];
  examinReq : OfferedAppointmentClass;

  previous: any = []; //pagination variable
  previousearch: string;

  constructor(private _transferService: TransferClinicService, private cdRef: ChangeDetectorRef, 
    private _clinicService: ListClinicsService, private _loginService : LoginService, private _examinationService : ExaminationService) { }
  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;

  ngOnInit(): void {
    this._transferService.clinic$.subscribe((data) => {
      if(data !== null){
        this.clinic = data;
        this.clinicName = this.clinic.name;
      }
    });

    this._clinicService.getClinicAppointments(this.clinic.id).subscribe(
      data =>{
        this.examinationsList = data;
        //set table
        this.mdbTable.setDataSource(this.examinationsList);
        this.examinationsList = this.mdbTable.getDataSource();
        this.previous = this.mdbTable.getDataSource();
        this.previousearch = this.mdbTable.getDataSource();
      }
    );
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  saveChanges(){
    this._examinationService.patientSendOneClickRequest(this.examinReq).subscribe(
      request => {
        //set table again
        this._clinicService.getClinicAppointments(this.clinic.id).subscribe(
          data =>{
            this.examinationsList = data;
            this.mdbTable.setDataSource(this.examinationsList);
            this.examinationsList = this.mdbTable.getDataSource();
            this.previous = this.mdbTable.getDataSource();
            this.previousearch = this.mdbTable.getDataSource();
          }
        );
      }
    );
  }

  makeAppointment(examin : OfferedAppointmentClass){
    examin.patientId = this._loginService.currentUser.userId;
    this.examinReq = examin;
  }

}
