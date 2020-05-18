import { Component, OnInit } from '@angular/core';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';
import { ClinicBasic, IClinicBasic } from 'src/app/model/clinicBasic';

@Component({
  selector: 'app-edit-clinic-basic',
  templateUrl: './edit-clinic-basic.component.html',
  styleUrls: ['./edit-clinic-basic.component.css']
})
export class EditClinicBasicComponent implements OnInit {

  // clinic: ClinicBasic = new ClinicBasic(null, "", "", "", "", "", 0);
  clinicId: number = 1;
  clinic: IClinicBasic; //ako validacija da su sva polja popunjena bude radila bez provere svakog polja, onda ovo ostaje.
  clinicName: string;

  constructor(
    private _httpClinicService: ClinicService
  ) { }

  ngOnInit(): void {
    this.loadClinic();
  }

  loadClinic() {
    this._httpClinicService.getOne(this.clinicId)
      .subscribe(response => {
        this.clinic = response;
        console.log(this.clinic.averageMark);
        console.log(this.clinic.city);
        console.log(this.clinic.country);
        console.log(this.clinic.id);
        console.log(this.clinic.name);
        console.log(this.clinic.street);
        this.clinicName = response.name;
      });
  }

  updateClinic() {
    this._httpClinicService.modify(this.clinic)
      .subscribe( response => {
        if (response != null) {
          alert("Clinic is updated successfuly.");
          this.clinicName = this.clinic.name;
        } else {
          alert("Clinic is not updated");
        }
      });
  }

}
