import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { IMedicalRoom, MedicalRoom } from 'src/app/model/medicalRoom';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {MatCardModule} from '@angular/material/card';

import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';
import { ICLinicToDisplay } from 'src/app/model/clinic';
import { ClinicService } from 'src/app/services/clinic-service/clinic.service';

@Component({
  selector: 'app-add-medical-room',
  templateUrl: './add-medical-room.component.html',
  styleUrls: ['./add-medical-room.component.css']
})
export class AddMedicalRoomComponent implements OnInit {

  labelValue: 'Operation' | 'Examination' = 'Examination';

  room: MedicalRoom = new MedicalRoom(null, "", this.labelValue, null);
  public clinics: Array<ICLinicToDisplay> = new Array<ICLinicToDisplay>();
  
  disabled = false;

  constructor(
    private httpRoomService: MedicalRoomService,
    private httpClinicService: ClinicService
  ) { }

  ngOnInit(): void {

    /* load clinics to choose in which we want to add doctor */
    this.httpClinicService.getAll().subscribe(response => {
      this.clinics = response;
    });
    
  }

  /* Method to send request and save doctor in database if all ok */
  addRoom(): void {
    
    if (this.room.filled()) {
      this.httpRoomService.addRoom(this.room)
      .subscribe(
        data => {
          alert("Room created successfully.");

          /* clean input fields */
          this.room.room_number = "";
        }
      )
    } else {
      alert("Fill other inputs.");
    }
  }

  onChange(inType): void {
    this.room.intervention_type = inType;
  }

}
