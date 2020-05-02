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
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective
  clinicList: any = [];
  previous: any = [];

  constructor(private _httpClinicsService: ListClinicsService, private cdRef: ChangeDetectorRef) {}

  

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
  }

}
