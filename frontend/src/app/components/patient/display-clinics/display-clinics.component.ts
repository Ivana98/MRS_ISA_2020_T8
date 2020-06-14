import { Component, OnInit, ViewChild, HostListener, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { ListClinicsService } from '../../../services/patient/clinics/list-clinics.service';
import { HttpClient } from '@angular/common/http';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { Clinic } from 'src/app/model/clinicToList';
import { TransferClinicService } from 'src/app/services/patient/clinics/transfer-clinic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-display-clinics',
  templateUrl: './display-clinics.component.html',
  styleUrls: ['./display-clinics.component.css']
})
export class DisplayClinicsComponent implements OnInit, AfterViewInit {
  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;

  clinicList: any = [];
  previous: any = []; //pagination variable
  searchText: string = '';
  previousearch: string; //search variable

  constructor(private _httpClinicsService: ListClinicsService, private cdRef: ChangeDetectorRef, 
    private _transferService: TransferClinicService, private _router: Router) { }

  @HostListener('input') oninput() { this.searchItems(); }

  ngOnInit(): void {
    this._httpClinicsService.getListForTable().subscribe(response => this.setResponse(response));
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }
  setResponse(r) {
    this._transferService.setClinicList(r);
    //binding clinicList to observable variable because of searching examinations
    this._transferService.clinicList$.subscribe(
      data => {
        if(data !== null){
          this.clinicList = data;
        }
      },
      error => {}
    );
    this.mdbTable.setDataSource(this.clinicList);
    this.clinicList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource();
  }

  searchItems() {
    const prev = this.mdbTable.getDataSource();

    if (!this.searchText) {
      this.mdbTable.setDataSource(this.previousearch);
      this.clinicList = this.mdbTable.getDataSource();
    }
    if (this.searchText) {
      this.clinicList = this.mdbTable.searchLocalDataBy(this.searchText);
      this.mdbTable.setDataSource(prev);
    }
  }

  rowSelected(cl: Clinic, rowNum : number) {
    this._transferService.setClinic(cl);
    this._transferService.setClinicRow(rowNum);
    this._router.navigate(['/user-page/clinicsTable/clinic']);
  }

}
