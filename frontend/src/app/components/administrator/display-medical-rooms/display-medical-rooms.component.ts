import { Component, OnInit, ChangeDetectorRef, HostListener, ViewChild, AfterViewInit } from '@angular/core';
import { MedicalRoomService } from 'src/app/services/medical-room-services/medical-room.service';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { MedicalRoom } from 'src/app/model/medicalRoom';
import { StartEndDate } from 'src/app/model/startEndDate';

@Component({
  selector: 'app-display-medical-rooms',
  templateUrl: './display-medical-rooms.component.html',
  styleUrls: ['./display-medical-rooms.component.css']
})
export class DisplayMedicalRoomsComponent implements OnInit, AfterViewInit {

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

  previous: any = [];
  searchText: string = ''; 
  previousearch: string;
  medical_room: MedicalRoom = new MedicalRoom(null, "", "", 0);

  rooms: Array<MedicalRoom> = [];
  interventionType: string;

  headElements = ['ID', 'Start date', 'End date'];
  appointments: Array<StartEndDate> = [];

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpMedicalRoomService: MedicalRoomService
  ) { }

  @HostListener('input') oninput() { this.searchItems(); } 

  ngOnInit(): void {
    this.loadMedicalRooms();
  }

  loadMedicalRooms() {
    this._httpMedicalRoomService.getAll()
      .subscribe(response => {
        this.setResponse(response);
      })
  }

  loadAppointments(room) {
    this._httpMedicalRoomService.getAllAppointmentsOfRoom(room.id)
      .subscribe(data => {
        this.appointments = data;
      });
  }

  getRow(data) {
    //when click on row
  }

  ngAfterViewInit() {
    this.pagination();
  }

  pagination() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  setResponse(response){
    this.rooms = response;
    this.mdbTable.setDataSource(this.rooms);
    this.rooms = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.rooms = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.rooms = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

  editRoom(room) {
    this.medical_room.intervention_type = room.intervention_type;
    this.medical_room.room_number = room.room_number;
    this.medical_room.id = room.id;
    this.medical_room.clinic_id = room.clinic_id;
  }

  saveChanges() {
    this._httpMedicalRoomService.modifyMedicalRoom(this.medical_room)
    .subscribe(data => {
      this.clearRoom();
    });
  }
  

  takeId(room) {
    this.medical_room.id = room.id;
  }

  deleteRoom() {
    this._httpMedicalRoomService.deleteMedicalRoom(this.medical_room.id)
      .subscribe( data => {
        console.log("Soba obrisana: " + data);
        if (data == true) {

          // delete room from table
          this.rooms.forEach( (item, index) => {
            if(item.id === this.medical_room.id) this.rooms.splice(index,1);
          });
        }
      });
  }

  onChange(data){
    this.interventionType = data;
  }

  clearRoom() {
    this.medical_room.intervention_type = "";
    this.medical_room.room_number = "";
  }

  addRoom() {
    if (this.medical_room.filled()) {
      this._httpMedicalRoomService.addRoom(this.medical_room)
      .subscribe(
        data => {
          console.log(data);
          // this.rooms.push(new MedicalRoom(data.id, data.room_number, data.intervention_type, data.clinic_id));  
          alert("Room created successfully.");
          this.rooms.push(data);
          this.pagination();
          /* clean input fields */
          this.clearRoom();
        }
      )
    } else {
      alert("Fill other inputs.");
    }
  }

  close() {
  }

}
