import { Component, OnInit, AfterViewInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
import { TransferClinicService } from 'src/app/services/patient/clinics/transfer-clinic.service';
import { Clinic } from 'src/app/model/clinicToList';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { DoctorForClinicList } from 'src/app/model/doctorForClinicList';

@Component({
  selector: 'app-clinic-info-page',
  templateUrl: './clinic-info-page.component.html',
  styleUrls: ['./clinic-info-page.component.css']
})
export class ClinicInfoPageComponent implements OnInit, AfterViewInit {

  clinic: Clinic;
  doctors : any = [];
  errorClinic: boolean;

  previous: any = []; //pagination variable
  searchText: string = '';
  previousearch: string; //search variable

  constructor(private _transferService: TransferClinicService, private cdRef: ChangeDetectorRef) { }
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

}
