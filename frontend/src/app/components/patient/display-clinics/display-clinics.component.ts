import { Component, OnInit } from '@angular/core';
import { ListClinicsService } from '../../../services/patient/clinics/list-clinics.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-display-clinics',
  templateUrl: './display-clinics.component.html',
  styleUrls: ['./display-clinics.component.css']
})
export class DisplayClinicsComponent implements OnInit {

  constructor(private _httpClinicsService: ListClinicsService) {}

  ngOnInit(): void {
    this._httpClinicsService.getListForTable().subscribe(response => this.clinicList = response);
  }

  clinicList: any = [];

}
