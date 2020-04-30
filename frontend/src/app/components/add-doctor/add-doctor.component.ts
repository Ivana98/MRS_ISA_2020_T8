import { Component, OnInit } from '@angular/core';
import { AddDoctorService } from 'src/app/services/add-doctor-service/add-doctor.service';
import { IDoctor2, Doctor2 } from 'src/app/model/doctor';
import { IAddress, Address } from 'src/app/model/address';
// import { InputsModule, WavesModule, ButtonsModule, CollapseModule } from 'angular-bootstrap-md'

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor: IDoctor2 = new Doctor2("", "", "", "", "", "", "", "");

  constructor(
    private httpClientService: AddDoctorService
  ) { }

  ngOnInit(): void {
    
  }

  /* Method to send request and save doctor in database if all ok */
  addDoctor(): void {
    this.httpClientService.addDoctor(this.doctor)
      .subscribe(
        data => {
          alert("Doctor created successfully.");
        }
      )
    
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
