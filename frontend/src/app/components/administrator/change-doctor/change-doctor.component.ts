import { Component, OnInit, AfterViewInit, Input } from '@angular/core';
import { DoctorShareService } from 'src/app/services/data-share/doctor-share/doctor-share.service';
import { Doctor } from 'src/app/model/doctor';
import { UserPassword } from 'src/app/model/userPassword';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';

@Component({
  selector: 'app-change-doctor',
  templateUrl: './change-doctor.component.html',
  styleUrls: ['./change-doctor.component.css']
})
export class ChangeDoctorComponent implements OnInit {

  // @Input() d: Doctor;

  doctor = new Doctor(null, "", "", "", "", "", "", "", "", "", "");
  doctorsList: Array<Doctor> = [];
  userPassword = new UserPassword(0, "", "", "");
  currentPasswordMatched : boolean = true;
  passwordConfirmed : boolean = true;
  doctorHasAppointment: boolean = false;
  changeDoctorSuccess: any; //boolean
  changePasswordSuccess:any; //boolean
  mmm: string;
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
    private _someLogic: DoctorShareService,
    private _httpDoctorService: DoctorService
    ) { }

  ngOnInit(): void {
    this._someLogic._userDoc$.subscribe(
      message => { 
        this.doctor = message 
      });

    this._someLogic._userLoad$.subscribe(
      message => { 
        this.doctorsList = message; 
      });
  }

  saveChanges(event) {
    this._httpDoctorService.modifyDoctor(this.doctor)
      .subscribe( data => {
        //Maybe delete this
      });
  }

  deleteDoctor(event) {
    this._httpDoctorService.deleteDoctor(this.doctor.id)
      .subscribe( data => {
        //Maybe delete this
      });

      this.doctorsList.forEach( (item, index) => {
        if(item.id === this.doctor.id) this.doctorsList.splice(index,1);
      });
  }

}
