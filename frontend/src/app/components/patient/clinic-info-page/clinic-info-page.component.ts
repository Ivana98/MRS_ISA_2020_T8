import { Component, OnInit, AfterViewInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
import { TransferClinicService } from 'src/app/services/patient/clinics/transfer-clinic.service';
import { Clinic } from 'src/app/model/clinicToList';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { DoctorForClinicList } from 'src/app/model/doctorForClinicList';
import { SaveMark } from 'src/app/model/saveMark';
import { RatingService } from 'src/app/services/patient/rating/rating.service';

@Component({
  selector: 'app-clinic-info-page',
  templateUrl: './clinic-info-page.component.html',
  styleUrls: ['./clinic-info-page.component.css']
})
export class ClinicInfoPageComponent implements OnInit, AfterViewInit {

  clinic: Clinic;
  clinicList : any = [];
  doctors : any = [];
  errorClinic: boolean;

  previous: any = []; //pagination variable
  searchText: string = '';
  previousearch: string; //search variable

  modalHeader = "";
  saveMark = new SaveMark(0, 0);
  clinicModal = true; // modal is used to rate clinic - true; for rate doctor - false

  constructor(private _transferService: TransferClinicService, private _ratingService: RatingService,private cdRef: ChangeDetectorRef) { }
  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;
  @HostListener('input') oninput() { this.searchItems(); }

  ngOnInit(): void {
    this.errorClinic = false;
    this._transferService.clinic$.subscribe((data) => {
      if(data !== null){
        this.clinic = data;
        this.doctors = this.clinic.doctors;
        this.mdbTable.setDataSource(this.doctors);
        this.doctors = this.mdbTable.getDataSource();
        this.previous = this.mdbTable.getDataSource();
        this.previousearch = this.mdbTable.getDataSource();
      }
      else{
        this.errorClinic = true;
      }
    });

    this._transferService.clinicList$.subscribe(
      data => {
        //uzmi red i postavi kliniku novu iz liste klinika
        //this.clinicList = data;
        var index : number = this._transferService.clinicRow$;
        this._transferService.setClinic(data[index]);
      }
    );
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
      this.doctors = this.mdbTable.getDataSource();
    }
    if (this.searchText) {
      this.doctors = this.mdbTable.searchLocalDataBy(this.searchText);
      this.mdbTable.setDataSource(prev);
    }
  }

  rateClinic(){
    this.modalHeader = "Please, rate clinic: " + this.clinic.name;
    this.saveMark.id = this.clinic.id;
    this.saveMark.mark = this.clinic.givenMark
    this.clinicModal = true;
  }

  rateDoctor(dr : DoctorForClinicList){
    this.modalHeader = "Please, rate your doctor: " + dr.firstName + " " + dr.lastName;
    this.saveMark.id = dr.doctorId;
    this.saveMark.mark = dr.givenMark;
    this.clinicModal = false;
  }

  saveChanges(){
    if(this.clinicModal){
      this._ratingService.setClinicRate(this.saveMark).subscribe(response => this.clinic = response);
    }
    else{
      this._ratingService.setDoctorRate(this.saveMark).subscribe(response => {
        if(response !== null){
          this.clinic = response;
          this.doctors = this.clinic.doctors;
        }
        else{
          this.errorClinic = true;
        }
      });
    }
  }

}
