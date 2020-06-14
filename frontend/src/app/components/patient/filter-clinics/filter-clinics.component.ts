import { Component, OnInit } from '@angular/core';
import { FilterClinicsClass } from 'src/app/model/searchFilterClinics';
import { formatDate } from '@angular/common';
import { TransferClinicService } from 'src/app/services/patient/clinics/transfer-clinic.service';
import { ListClinicsService } from 'src/app/services/patient/clinics/list-clinics.service';

@Component({
  selector: 'app-filter-clinics',
  templateUrl: './filter-clinics.component.html',
  styleUrls: ['./filter-clinics.component.css']
})
export class FilterClinicsComponent implements OnInit {

  constructor(private _transferClinicService: TransferClinicService, private _listClinicsService: ListClinicsService) { }

  date = new Date();;
  time = "";
  filterCl = new FilterClinicsClass("", this.date);
  //specialisations is enum type
  specialisations = [
    "OPHTALMOLOGY",
    "CARDIOLOGY",
    "LABORATORY",
    "PULMONOLOGY",
    "SYSTEMATIC_REVIEW",
    "GYNECOLOGY",
    "PSYHOLOGY",
    "OTOLARYNGOLOGY",
    "INTERNIST"
  ];

  ngOnInit(): void {
  }

  filter(){
    this.date.setHours(Number(this.time.substring(0,2)));
    this.date.setMinutes(Number(this.time.substring(3,5)));
    this.date.setSeconds(0);
    this.filterCl.searchedDate = this.date;
    //call endpoint and update clinicList observable
    this._listClinicsService.getFilteredClinics(this.filterCl).subscribe(
      response => {
        if(response != null){
          this._transferClinicService.setClinicList(response);
        }
      },
      error => {}
      );
  }

  public onDate(event): void {
    this.date = event;
  }

  public onDateChange(event): void {
    this.date = event;
  }

}
