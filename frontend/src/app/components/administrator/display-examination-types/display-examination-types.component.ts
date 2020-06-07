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
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective;

  duration = 
  [
    '00:05',
    '00:10',
    '00:15',
    '00:20',
    '00:25',
    '00:30',
    '00:40',
    '00:50',
    '01:00',
    '01:15',
    '01:30',
    '01:45',
    '02:00',
    '02:30',
    '03:00',
    '03:30',
    '04:00',
    '04:30',
    '05:00',
    '06:00',
    '07:00',
    '08:00',
    '09:00',
    '10:00',
    '11:00',
    '12:00',
    '13:00',
    '14:00',
    '15:00',
    '16:00',
    '17:00',
    '18:00',
    '19:00',
    '20:00',
    '21:00',
    '22:00',
    '23:00',
    '24:00'
  ];

  isChangeHidden = true;
  durationToChange: string = "00:00";
  durationToAdd: string = "00:00";


  ETList: Array<FullPrice> = [];
  previous: any = [];

  labelValue: 'OPERATION' | 'EXAMINATION' = 'EXAMINATION';
  specialisations: Array<string> = [];

  priceToChange: FullPrice = new FullPrice(0, 0, 0, 0, "", "", 0);
  priceToAdd: FullPrice = new FullPrice(0, 0, 0, 0, this.labelValue, "", 0);

  etToDeleteId: number = -1;

  searchText: string = ''; 
  previousearch: string; //search variable

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpPriceService: PriceService
  ) { }

  @HostListener('input') oninput() { this.searchItems();} 

  ngOnInit(): void {
    this.loadETs();
  }

  /**
   * load all prices from clinic.
   */
  loadETs() {
    this._httpPriceService.loadAllByClinicId()
      .subscribe(response => {
        this.setResponse(response);
        this.loadSpecialisations();
      });
  }

  /**
   * Load all specialisations which clinic has from prices previously loaded.
   */
  loadSpecialisations() {
    this.ETList.forEach(fullPrice => {
      //If list doesn't contain specialisation, add it to list.
      if (this.specialisations.indexOf(fullPrice.specialisation) == -1) {
        this.specialisations.push(fullPrice.specialisation);
      }
    });
  }

  getRow(data) {
    // this._someLogic.sendDoctor(data);
    // this._someLogic.loadDoctorsAgain(this.ETList);
  }

  ngAfterViewInit() {
    this.calculatePagination();
  }

  calculatePagination() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  setResponse(response) {
    this.ETList = response;
    this.mdbTable.setDataSource(this.ETList);
    this.ETList = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems() {
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

  /**
   * 
   * @param et is FullPrice object selected from table
   */
  editET(et) {
    // show change form
    this.isChangeHidden = false;
    this.priceToChange = et;

    // hours
    var hoursInt = et.duration/60 | 0;
    var hoursStr;
    if (hoursInt == 0)
      hoursStr = "00";
    else if (hoursInt < 10)
      hoursStr = "0" + hoursInt;
    else
      hoursStr = "" + hoursInt;
    
    // minutes
    var minutesInt = et.duration % 60;
    var minutesStr;
    if (minutesInt == 0)
      minutesStr = "00";
    else if (minutesInt < 10)
      minutesStr = "0" + minutesInt;
    else
      minutesStr = "" + minutesInt;

    this.durationToChange = hoursStr + ":" + minutesStr;
  }

  /**
   * send request to save changes for chossen and edited ET(Price).
   */
  confirmChanges() {
    this._httpPriceService.update(this.priceToChange)
      .subscribe(response => {
        if (response != null) {
          alert("Examination type (price) is successfuly updated.");
        }
      });
  }

  takeET(et) {
    this.etToDeleteId = et.id;
  }

  delete() {
    this._httpPriceService.delete(this.etToDeleteId)
      .subscribe(response => {
        if (response == true) {
          alert("ET (price) is deleted.");

          // delete price from list
          this.ETList.forEach( (item, index) => {
            if(item.id === this.etToDeleteId) this.ETList.splice(index,1);
          });

          // set row number in bottom of table (pagination)
          this.mdbTable.setDataSource(this.ETList);
        }
      });
  }

  onChange(inType): void {
    this.priceToAdd.intervention_type = inType;
  }

  /**
   * 
   */
  add() {
    var hours = Number(this.durationToAdd.substring(0,2));
    var minutes = Number(this.durationToAdd.substring(3,5));
    var dur = hours * 60 + minutes;

    this.priceToAdd.duration = dur;

    // if there is et with same intervention type and specialisation, do not send request to server
    var ok = true;
    this.ETList.forEach( (item, index) => {
      if(item.intervention_type == this.priceToAdd.intervention_type &&
        item.specialisation == this.priceToAdd.specialisation) ok = false;
    });

    if (ok == true)
      this._httpPriceService.add(this.priceToAdd)
        .subscribe(response => {
          console.log("response: " + response);
          alert("ET created successfuly.");

          this.ETList.push(this.priceToAdd);
          this.mdbTable.setDataSource(this.ETList);
          this.ETList = this.mdbTable.getDataSource();
          this.previous = this.mdbTable.getDataSource();
          this.previousearch = this.mdbTable.getDataSource(); 
        });
    else
      alert("ET with this specicalisation and intervention type already exists.");
  }

}
