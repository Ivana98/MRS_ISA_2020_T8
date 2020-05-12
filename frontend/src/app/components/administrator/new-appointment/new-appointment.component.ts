import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { Doctor } from 'src/app/model/doctor';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { ExaminationType } from 'src/app/model/examinationType';
import { ExaminationTypeService } from 'src/app/services/examination-type/examination-type.service';
import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';
import { UserProfile } from 'src/app/model/userProfile';
import { ClinicAdminService } from 'src/app/services/clinic-admin-service/clinic-admin.service';
import { MedicalRoom } from 'src/app/model/medicalRoom';
import { Examination } from 'src/app/model/examination';
import { Time } from '@angular/common';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';

@Component({
  selector: 'app-new-appointment',
  templateUrl: './new-appointment.component.html',
  styleUrls: ['./new-appointment.component.css']
})
export class NewAppointmentComponent implements OnInit {

  labelValue: 'Operation' | 'Examination' = 'Examination';
  duration = 
  [
    '00:05', '00:10', '00:15', '00:20', '00:25',
    '00:30', '00:40', '00:50', '01:00', '01:15',
    '01:30', '01:45', '02:00', '02:30', '03:00',
    '03:30', '04:00', '04:30', '05:00', '06:00',
    '07:00', '08:00', '09:00', '10:00', '11:00',
    '12:00', '13:00', '14:00', '15:00', '16:00',
    '17:00', '18:00', '19:00', '20:00', '21:00',
    '22:00', '23:00', '24:00'
  ];
  public examination_type: ExaminationType = new ExaminationType(null, 0, "", this.labelValue, "");
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

  date = new Date();// = new Date();
  // time = new Date();
  time: string;

  myControl = new FormControl();
  filteredOptions2: Observable<Doctor[]>;
  types: Array<ExaminationType> = [];

  doctors: Doctor[] = [];
  room: MedicalRoom;
  rooms: Array<MedicalRoom> = [];
  examination = new Examination(null, null, null, null, null, null, null, null, null, null, this.labelValue, null);
  price: number;

  //this will be current user when login done
  currentUser = new UserProfile(1, "", "", "", "", "", "", "", "");

  constructor(
    private _httpDoctorService: DoctorService,
    private _httpClinicAdminService: ClinicAdminService,
    private _httpExaminationService: ExaminationService
    ) {}

  ngOnInit() {
    this.loadDoctors();
    this.loadMedicalRooms();
  }

  loadDoctors() {
    this._httpDoctorService.getDoctors()
      .subscribe(response => {
        this.doctors = response;
        this.filter();
      });
  }

  loadMedicalRooms() {
    this._httpClinicAdminService.getRoomsFromClinic(this.currentUser.id)
    .subscribe(response => {
      this.rooms = response;
    });
  }

  filter() {
    this.filteredOptions2 = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  getTime() {
    console.log(this.time)
  }

  private _filter(value: string): Doctor[] {
    console.log("Vrednost: " + value);
    const filterValue = value.toLocaleLowerCase();

    return this.doctors.filter(option => (option.firstName + " " + option.lastName).toLowerCase().includes(filterValue));
  }

  selectDoctor(doctor) {
    // console.log("IME: " + doctor.firstName);
    this.examination.doctorId = doctor.id;
  }

  public onDate(event): void {
    this.date = event;
    console.log("Datum: " + this.date);
  }

  onChange(inType): void {
    this.examination.interventionType = inType;
  }

  addExamination() {
    this.date.setHours(Number(this.time.substring(0,2)));
    this.date.setMinutes(Number(this.time.substring(3,5)));
    this.date.setSeconds(0);
    this.examination.date = this.date;

    console.log(this.examination.doctorId);

    this._httpExaminationService.addExamination(this.examination)
    .subscribe(response => {
      console.log("Odmogvor sa servera: " + response);
    });
  }

}


