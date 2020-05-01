import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { IMedicalRoom, MedicalRoom } from 'src/app/model/medicalRoom';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {MatCardModule} from '@angular/material/card';

import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';

@Component({
  selector: 'app-add-medical-room',
  templateUrl: './add-medical-room.component.html',
  styleUrls: ['./add-medical-room.component.css']
})
export class AddMedicalRoomComponent implements OnInit {

  room: IMedicalRoom = new MedicalRoom("", "");

  labelValue: 'Operation' | 'Examination' = 'Examination';
  disabled = false;

  constructor(
    private httpClientService: MedicalRoomService
  ) { }

  ngOnInit(): void {
  }

  /* Method to send request and save doctor in database if all ok */
  addRoom(): void {
    
    this.httpClientService.addRoom(this.room)
      .subscribe(
        data => {
          alert("Room created successfully.");
        }
      )

      //TODO: Just one inversion type can be checked
    
    /* clean input fields */
    // this.room.number = "";
  }

  onChange(inType): void {
    this.room.inversionType = inType;
  }

}
