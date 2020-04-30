import { Component, OnInit } from '@angular/core';
import { IMedicalRoom, MedicalRoom } from 'src/app/model/medicalRoom';
import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';

@Component({
  selector: 'app-add-medical-room',
  templateUrl: './add-medical-room.component.html',
  styleUrls: ['./add-medical-room.component.css']
})
export class AddMedicalRoomComponent implements OnInit {

  room: IMedicalRoom = new MedicalRoom("", "");

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

}
