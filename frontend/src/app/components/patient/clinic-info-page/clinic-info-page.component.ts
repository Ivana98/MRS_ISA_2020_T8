import { Component, OnInit } from '@angular/core';
import { TransferClinicService } from 'src/app/services/patient/clinics/transfer-clinic.service';
import { Clinic } from 'src/app/model/clinicToList';

@Component({
  selector: 'app-clinic-info-page',
  templateUrl: './clinic-info-page.component.html',
  styleUrls: ['./clinic-info-page.component.css']
})
export class ClinicInfoPageComponent implements OnInit {

  //clinic: Clinic;

  //constructor(private _transferService: TransferClinicService) { }

  ngOnInit(): void {
    //this._transferService.clinic$.subscribe((data) => {this.clinic = data});
  }

}
