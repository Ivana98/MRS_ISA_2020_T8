import { Component, OnInit } from '@angular/core';
import { RegistrationClinicAdminServiceService } from '../../../services/clinical-center-administrator/registration-clinic-admin/registration-clinic-admin-service.service';
import { ClinicAdmin } from '../../../model/clinicAdmin';
import { ClinicService } from 'src/app/services/clinic-service/clinic-service.service';
import { ICLinicToDisplay } from 'src/app/model/clinic';

@Component({
  selector: 'app-registration-clinic-admin',
  templateUrl: './registration-clinic-admin.component.html',
  styleUrls: ['./registration-clinic-admin.component.css']
})
export class RegistrationClinicAdminComponent implements OnInit {

  clinicAdmin: ClinicAdmin = new ClinicAdmin("", "", "", "", "", "", "", "");
  public clinics: Array<ICLinicToDisplay> = new Array<ICLinicToDisplay>();

  constructor(
    private httpClientService: RegistrationClinicAdminServiceService,
    private httpClinicService: ClinicService
  ) { }

  ngOnInit(): void {
    this.httpClinicService.getAll().subscribe(response => {
      this.clinics = response;
    });
  }

  /* Method to send request and save doctor in database if all ok */
  addClinicAdmin(): void {
 
    this.httpClientService.addClinicAdmin(this.clinicAdmin)
      .subscribe(
        data => {
          alert("Clinic Admin created successfully.");
        }
      )
      console.log("YAYAYA");
  
  }


}
