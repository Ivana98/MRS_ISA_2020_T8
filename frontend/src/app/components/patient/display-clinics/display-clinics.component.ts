import { Component, OnInit, ViewChild, HostListener, AfterViewInit, ChangeDetectorRef  } from '@angular/core';
import { ListClinicsService } from '../../../services/patient/clinics/list-clinics.service';
import { HttpClient} from '@angular/common/http';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';

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

  constructor(private _httpClinicsService: ListClinicsService, private cdRef: ChangeDetectorRef) {}

  @HostListener('input') oninput() { this.searchItems();} 

  ngOnInit(): void {
    this._httpClinicsService.getListForTable().subscribe(response => this.setResponse(response));
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }
  setResponse(r){
    console.log(r);
    this.clinicList = r;
    this.mdbTable.setDataSource(this.clinicList);
    this.clinicList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.clinicList = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        //this.clinicList = this.mdbTable.searchLocalDataByMultipleFields(this.searchText, ['name', 'adressCity', 'adressStreet']); 
        this.clinicList = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

}
