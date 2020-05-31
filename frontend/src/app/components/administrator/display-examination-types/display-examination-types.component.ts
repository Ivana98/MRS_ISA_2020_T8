import { Component, OnInit, ViewChild, ChangeDetectorRef, HostListener } from '@angular/core';
import { MdbTableDirective, MdbTablePaginationComponent } from 'angular-bootstrap-md';
import { ExaminationType } from 'src/app/model/examinationType';
import { ExaminationTypeService } from 'src/app/services/examination-type/examination-type.service';
import { PriceService } from 'src/app/services/price-service/price.service';
import { LoginService } from 'src/app/services/login-service/login.service';
import { FullPrice } from 'src/app/model/price';

@Component({
  selector: 'app-display-examination-types',
  templateUrl: './display-examination-types.component.html',
  styleUrls: ['./display-examination-types.component.css']
})
export class DisplayExaminationTypesComponent implements OnInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

  ETList: Array<FullPrice> = [];
  previous: any = [];

  searchText: string = ''; 
  previousearch: string; //search variable

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpETService: ExaminationTypeService,
    private _httpPriceService: PriceService
  ) { }

  @HostListener('input') oninput() { this.searchItems();} 

  ngOnInit(): void {
    this.loadETs();
  }

  loadETs() {
    this._httpPriceService.loadAllByClinicId().subscribe(response => this.setResponse(response))
  }

  getRow(data) {
    // this._someLogic.sendDoctor(data);
    // this._someLogic.loadDoctorsAgain(this.ETList);
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  setResponse(response){
    this.ETList = response;
    this.mdbTable.setDataSource(this.ETList);
    this.ETList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.ETList = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.ETList = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

}
