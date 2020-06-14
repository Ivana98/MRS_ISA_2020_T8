import { Component, OnInit, Output } from '@angular/core';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { IDoctor, Doctor } from 'src/app/model/doctor';
import { ICLinicToDisplay } from 'src/app/model/clinic';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';
import { EventEmitter } from 'protractor';
import { NullTemplateVisitor } from '@angular/compiler';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor: Doctor = new Doctor(null, "", "", "", "", "", "", "", "", "", "");
  public clinics: Array<ICLinicToDisplay> = new Array<ICLinicToDisplay>();
  buttonDisabled: boolean = false;
  specialisations: string[] = 
  [
    'OPHTALMOLOGY',
    'CARDIOLOGY',
    'LABORATORY',
    'PULMONOLOGY',
    'SYSTEMATIC_REVIEW',
    'GYNECOLOGY',
    'PSYHOLOGY',
    'OTOLARYNGOLOGY',
    'INTERNIST'
  ];

  constructor(
    private httpDoctorService: DoctorService, 
    private httpClinicService: ClinicService,
    private _router: Router
  ) { }

  ngOnInit(): void {

    /* load clinics to choose in which we want to add doctor */
    this.httpClinicService.getAll().subscribe(response => {
      this.clinics = response;
    });

  }

  /* Method to send request and save doctor in database if all ok */
  addDoctor(): void {
    if (this.doctor.filled()) {
      this.httpDoctorService.addDoctor(this.doctor)
      .subscribe(
        data => {
          alert("Doctor created successfully.");
          this._router.navigate(['/user-page/displayDoctors']);
        }
      )
    } else {
      alert("Fill other inputs.");
    }
    
    
    /* clean input fields */
    // this.doctor.password = "";
    // this.doctor.firstName = "";
    // this.doctor.email = "";
    // this.doctor.phone = "";
    // this.doctor.lastName = "";
    // this.address.city = "";
    // this.address.country = "";
    // this.address.street = "";
  }

}
