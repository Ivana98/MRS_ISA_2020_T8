import { Component, OnInit, Input } from '@angular/core';
import { Absence } from 'src/app/model/absence';
import { AbsenceService } from 'src/app/services/absence-service/absence.service';

@Component({
  selector: 'app-absence',
  templateUrl: './absence.component.html',
  styleUrls: ['./absence.component.css']
})
export class AbsenceComponent implements OnInit {

  minDate: Date;
  maxDate: Date;

  startDate: Date = new Date(new Date().getDate() + 1);
  endDate: Date = new Date(new Date().getDate() + 2);

  absence: Absence = new Absence(null, this.startDate, this.endDate, "sick_leave", false, -1);

  constructor(
    private _httpAbsenceService: AbsenceService
  ) {
    // Set the minimum to tomorrow and maximum 2 years in future (31. December)
    const currentYear = new Date().getFullYear();
    const currentMonth = new Date().getMonth();
    const currentDay = new Date().getDate();
    this.minDate = new Date(currentYear + 0, currentMonth, currentDay + 1);
    this.maxDate = new Date(currentYear + 1, 11, 31);
  }

  ngOnInit(): void {
  }

  /**
   * Set choosen absence type.
   * 
   * @param data is string absence or vacation
   */
  onChange(data){
    this.absence.absenceType = data;
  }

  sendRequest() {
    //TODO: uraditi slanje zahteva preko majela adminu, koji ce to kasnije da potvrdi.
    console.log("TODO...");
    this._httpAbsenceService.sendAbsenceRequest(this.absence)
      .subscribe(response => {

      });
      
  }

}
