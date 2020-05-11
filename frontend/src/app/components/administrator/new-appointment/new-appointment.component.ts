import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { Doctor } from 'src/app/model/doctor';
import { DoctorService } from 'src/app/services/doctor-service/doctor.service';
import { ExaminationType } from 'src/app/model/examinationType';
import { ExaminationTypeService } from 'src/app/services/examination-type/examination-type.service';
import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';

@Component({
  selector: 'app-new-appointment',
  templateUrl: './new-appointment.component.html',
  styleUrls: ['./new-appointment.component.css']
})
export class NewAppointmentComponent implements OnInit {

  date: any;// = new Date();
  time: any;

  myControl = new FormControl();
  options: string[] = ['One', 'Two', 'Three'];
  filteredOptions2: Observable<Doctor[]>;
  types: Array<ExaminationType> = [];

  doctors: Doctor[] = [];

  constructor(
    private _httpDoctorService: DoctorService,
    private _httpExaminationType: ExaminationTypeService,
    private _httpMedicalRoomService: MedicalRoomService
    ) {}

  ngOnInit() {

    this.loadDoctors();
    // this.filter();
  }

  loadDoctors() {
    this._httpDoctorService.getDoctors()
      .subscribe(response => {
        this.doctors = response;
        this.filter();
      });
  }

  loadMedicalRooms() {
    // this._httpMedicalRoomService.get()
    //   .subscribe(response => {
    //     this.doctors = response;
    //     this.filter();
    //   });
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
    console.log("IME: " + doctor.firstName);
  }

  public onDate(event): void {
    this.date = event;
    console.log("Datum: " + this.date);
  }

}


