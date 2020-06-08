import {Component, OnInit, ChangeDetectorRef, ViewChild, AfterViewInit, HostListener, Inject, NgModule} from '@angular/core';
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
import { FreeExaminationToDisplay } from 'src/app/model/FreeExaminationToDisplay';
import { Time, formatDate } from '@angular/common';
import { ExaminationService } from 'src/app/services/examination-service/examination.service';
import { PriceService } from 'src/app/services/price-service/price.service';
import { MdbTablePaginationComponent, MdbTableDirective } from 'angular-bootstrap-md';
import { FullPrice } from 'src/app/model/price';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
declare var $: any;

/**
 * example interface. DELETE THIS
 */
export interface DialogData {
  animal: string;
  name: string;
}

@Component({
  selector: 'app-new-appointment',
  templateUrl: './new-appointment.component.html',
  styleUrls: ['./new-appointment.component.css']
})
export class NewAppointmentComponent implements OnInit, AfterViewInit {

  ///////////////  DELETE THIS
  animal: string;
  name: string;
  ///////////////  DELETE THIS

  @ViewChild(MdbTablePaginationComponent, { static: true }) mdbTablePagination: MdbTablePaginationComponent;
  @ViewChild(MdbTableDirective, { static: true }) mdbTable: MdbTableDirective

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
  specialisations: string[] = [];
  specialisationChecked: boolean = false;

  date = new Date();
  dateChange = new Date();
  time: string;
  timeChange: string;

  myControlDoctor = new FormControl();
  myControlDoctorChange = new FormControl();
  myControlRoom = new FormControl();
  myControlRoomChange = new FormControl();

  filteredOptionsDoctor: Observable<Doctor[]>;
  filteredOptionsDoctorChange: Observable<Doctor[]>;
  filteredOptionsMedicalRoom: Observable<MedicalRoom[]>;
  filteredOptionsMedicalRoomChange: Observable<MedicalRoom[]>;

  doctors: Doctor[] = [];
  rooms: MedicalRoom[] = [];
  roomsChange: MedicalRoom[] = [];
  doctorsBySpecialisation: Array<Doctor> = [];
  doctorsBySpecialisationChange: Array<Doctor> = [];
  fullPrices: Array<FullPrice> = [];
  room: MedicalRoom;
  examinations: Array<Examination>;

  // examinations to display in table
  examinations2: Array<FreeExaminationToDisplay> = [];
  examination = new Examination(null, this.date, false, "", 0, null, null, null, null, null, this.labelValue, null);
  examinationChange = new Examination(null, this.date, false, "", 0, null, null, null, null, null, this.labelValue, null);
  price: number;

  previous: any = [];
  searchText: string = ''; 
  previousearch: string;

  //this will be current user when login done
  currentUser = new UserProfile(1, "", "", "", "", "", "", "", "");

  constructor(
    private cdRef: ChangeDetectorRef,
    private _httpDoctorService: DoctorService,
    private _httpClinicAdminService: ClinicAdminService,
    private _httpExaminationService: ExaminationService,
    private _httpMedicalRoomService: MedicalRoomService,
    private _httpPriceService: PriceService,
    public dialog: MatDialog
    ) {}

  @HostListener('input') oninput() { this.searchItems(); } 

  ngOnInit() {
    this.loadDoctors();
    this.loadMedicalRooms();
    this.loadFreeExaminations();
    this.loadPricesByClinicId();
  }

  ngAfterViewInit() {
    this.mdbTablePagination.setMaxVisibleItemsNumberTo(5);
    this.mdbTablePagination.calculateFirstItemIndex();
    this.mdbTablePagination.calculateLastItemIndex();
    this.cdRef.detectChanges();
  }

  /**
   * Load all Prices (FullPrice objects) from admin's clinic.
   */
  loadPricesByClinicId() {
    this._httpPriceService.loadAllByClinicId()
    .subscribe(response => {
      this.fullPrices = response;
      this.loadSpecialisations();
    });
  }

  /**
   * Load all specialisations which clinic has from prices previously loaded.
   */
  loadSpecialisations() {
    this.fullPrices.forEach(fullPrice => {
      //If list doesn't contain specialisation, add it to list.
      if (this.specialisations.indexOf(fullPrice.specialisation) == -1) {
        this.specialisations.push(fullPrice.specialisation);
      }
    });
  }

  /*
    Load all free examinations for one click reservation
  */
  loadFreeExaminations() {
    this._httpExaminationService.loadAllFreeExaminationsFromClinic()
      .subscribe(response => {
        this.setResponse(response);
      });
  }

  /**
   * all free examinations and create examinations for displaying in table.
   * Also adjust searching by all columns.
   * 
   * @param response is Examination list
   */
  setResponse(response) {
    this.examinations = response;

    // create new FreeExaminationToDisplays and add to list
    response.forEach(examination => {
      var id = examination.id;
      var roomNumber;
      this.rooms.forEach(room => {
        if (room.id = examination.medicalRoomId) {
          roomNumber = room.room_number;
        }
      });

      // first name plus last name
      var doctorName;
      this.doctors.forEach(element2 => {
        if (element2.id == examination.doctorId) {
          doctorName = element2.firstName + " " + element2.lastName;
        }
      });

      var duration = Number(examination.duration);
      var interventionType = examination.interventionType;
      var specialisation = examination.specialisation;
      
      // price of object Price
      var price = examination.price;

      var date = examination.date;

      var formattedDate = formatDate(date, 'dd.MM.yyyy. HH:mm', 'en-US');
      
      // Add new FreeExaminationToDisplay object to list
      this.examinations2.push(new FreeExaminationToDisplay(id, roomNumber, doctorName, duration, interventionType, specialisation, price, date, formattedDate));
    });

    this.mdbTable.setDataSource(this.examinations2);
    this.examinations2 = this.mdbTable.getDataSource();
    this.previous = this.mdbTable.getDataSource();
    this.previousearch = this.mdbTable.getDataSource(); 
  }

  searchItems(){
    const prev = this.mdbTable.getDataSource(); 
    
    if (!this.searchText) {
        this.mdbTable.setDataSource(this.previousearch); 
        this.examinations2 = this.mdbTable.getDataSource(); 
    } 
    if (this.searchText) { 
        this.examinations2 = this.mdbTable.searchLocalDataBy(this.searchText);
        this.mdbTable.setDataSource(prev); 
    } 
  }

  /**
   * This method returns Price object by id
   * 
   * @param priceId is id of Price 
   */
  getPrice(priceId) {
    var price;

    this._httpPriceService.getOne(priceId)
    .subscribe(response => {
      price = response;
    })

    return price;
  }

  /**
   * Load all doctors from logged in admin's clinic
   */
  loadDoctors() {
    this._httpDoctorService.getAllByClinic()
      .subscribe(response => {
        this.doctors = response;
      });
  }

  /**
   * Load all medical rooms from logged in admin's clinic by intervention type examination.
   */
  loadMedicalRooms() {
    this._httpMedicalRoomService.getAllByExamination()
    .subscribe(response => {
      this.rooms = response;
      this.roomsChange = response;
      this.filterRooms();
      this.filterRoomsChange();
    });
  }

  /**
   * Delete free examination by id.
   */
  deleteFreeExamination() {
    this._httpExaminationService.delete(this.examination.id)
      .subscribe();
  }

  /**
   * Method which take(save) id of choosen examination which we want to delete.
   * 
   * @param freeExamination is FreeExaminationToDisplay
   */
  takeId(freeExamination) {
    this.examination.id = freeExamination.id;
  }

  /**
   * Clear object attributes if needed.
   */
  clearExamination() {
    //TODO:
  }

  /**
   * Find doctors by specialisation.
   * 
   * @param spec is Specialisation
   */
  setDoctors(spec) {
    // clear list
    this.doctorsBySpecialisation = [];

    // clear doctor input on specialisation change
    $('#doctorInput').val('');

    // find doctors with forwarded specialisation na put in list.
    this.doctors.forEach(doctor => {
      if (doctor.specialisation == spec) {
        this.doctorsBySpecialisation.push(doctor);
      }
    });

    // for autocomplete
    this.filterDoctors();
  }

  /**
   * Find doctors by specialisation.
   * 
   * @param spec is Specialisation
   */
  setDoctorsChange(spec) {
    // clear list
    this.doctorsBySpecialisationChange = [];

    // clear doctor input on specialisation change
    $('#doctorInputChange').val('');

    // find doctors with forwarded specialisation na put in list.
    this.doctors.forEach(doctor => {
      if (doctor.specialisation == spec) {
        this.doctorsBySpecialisationChange.push(doctor);
      }
    });

    // for autocomplete
    this.filterDoctorsChange();
  }

  /**
   * Autocomplete for doctors by choosen specialisation.
   */
  filterDoctors() {
    this.filteredOptionsDoctor = this.myControlDoctor.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filterDoctors(value))
      );
  }

  /**
   * Method for modifying examination form.
   * Autocomplete for doctors by choosen specialisation.
   */
  filterDoctorsChange() {
    this.filteredOptionsDoctorChange = this.myControlDoctor.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filterDoctorsChange(value))
      );
  }
  
  /**
   * Autocomplete for medical rooms.
   */
  filterRooms() {
    this.filteredOptionsMedicalRoom = this.myControlRoom.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filterRooms(value))
      );
  }

  /**
   * Autocomplete for medical rooms.
   */
  filterRoomsChange() {
    this.filteredOptionsMedicalRoomChange = this.myControlRoomChange.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filterRoomsChange(value))
      );
  }

  /**
   * Filter doctor list. This method will be called on every pressed word from keyboard.
   * 
   * @param value is data from doctor input
   * @returns Doctor list
   */
  private _filterDoctors(value: string): Doctor[] {
    const filterValue = value.toLocaleLowerCase();

    return this.doctorsBySpecialisation.filter(option => (option.firstName + " " + option.lastName).toLowerCase().includes(filterValue));
  }

  /**
   * Filter doctor list. This method will be called on every pressed word from keyboard.
   * 
   * @param value is data from doctor input
   * @returns Doctor list
   */
  private _filterDoctorsChange(value: string): Doctor[] {
    const filterValue = value.toLocaleLowerCase();

    return this.doctorsBySpecialisationChange.filter(option => (option.firstName + " " + option.lastName).toLowerCase().includes(filterValue));
  }

  /**
   * Filter medical room list. This method will be called on every pressed word from keyboard.
   * 
   * @param value is data from room number input
   * @returns MedicalRoom list
   */
  private _filterRooms(value: string): MedicalRoom[] {
    const filterValue = value.toLocaleLowerCase();

    return this.rooms.filter(option => (option.room_number).toLowerCase().includes(filterValue));
  }

  /**
   * Filter medical room list. This method will be called on every pressed word from keyboard.
   * 
   * @param value is data from room number input
   * @returns MedicalRoom list
   */
  private _filterRoomsChange(value: string): MedicalRoom[] {
    const filterValue = value.toLocaleLowerCase();

    return this.roomsChange.filter(option => (option.room_number).toLowerCase().includes(filterValue));
  }

  /**
   * Take date from date input on click.
   * 
   * @param event is choosen date
   */
  public onDate(event): void {
    this.date = event;
    console.log("Datum: " + this.date);
  }

  /**
   * Take date on date input on click
   * 
   * @param event is choosen date
   */
  public onDateChange(event): void {
    this.dateChange = event;
    console.log("Datum promenjen: " + this.dateChange);
  }

  /**
   * Set date and send request to add free examination to database
   */
  addFreeExamination() {
    this.date.setHours(Number(this.time.substring(0,2)));
    this.date.setMinutes(Number(this.time.substring(3,5)));
    this.date.setSeconds(0);
    this.examination.date = this.date;

    // console.log(this.examination.doctorId);
    // console.log(this.examination.date);
    // console.log(this.examination.description);
    // console.log(this.examination.duration);
    // console.log(this.examination.interventionType);
    // console.log(this.examination.medicalRoomId);
    // console.log(this.examination.specialisation);
    // console.log(this.examination.wasOnExamination);

    // set price id
    this.fullPrices.forEach(fullPrice => {
      if (fullPrice.intervention_type.toLocaleLowerCase() == this.examination.interventionType.toLowerCase() 
      && fullPrice.specialisation.toLocaleLowerCase() == this.examination.specialisation.toLocaleLowerCase()) {
        this.examination.priceId = fullPrice.id;
        this.examination.duration = String(fullPrice.duration);
      }
    });

    // console.log(this.examination.priceId);
    // console.log(this.examination.duration)

    this._httpExaminationService.addFreeExamination(this.examination)
    .subscribe(response => {
      console.log("Odmogvor sa servera: " + response);
      if (response == null) {
        alert("Examination not added, try again.");
      }
    });
  }

  editFreeExamination() {
    console.log("TODO: editFreeExamination() method") 
  }

  /**
   * Set doctor id to examination.
   * 
   * @param doctor is selected Doctor
   */
  selectDoctor(doctor) {
    this.examination.doctorId = doctor.id;
  }

  /**
   * Set doctor id to examination for changing.
   * 
   * @param doctor is selected Doctor
   */
  selectDoctorChange(doctor) {
    this.examinationChange.doctorId = doctor.id;
  }

  /**
   * Set medical room id to examination.
   * 
   * @param room is MedicalRoom
   */
  selectRoom(room) {
    this.examination.medicalRoomId = room.id;
  }

  /**
   * Set medical room id to modified examination.
   * 
   * @param room  is MedicalRoom
   */
  selectRoomChange(room) {
    this.examinationChange.medicalRoomId = room.id;
  }

  /**
   * Take choosen examination.
   * 
   * @param examination is Examination
   */
  takeExamination(examination) {
    this.examinationChange = examination

    $('#doctorInputChange').val(examination.doctorName);
    $('#roomInputChange').val(examination.roomNumber);
    $('#dateInputChange').val(formatDate(examination.date, 'MM/dd/yyyy', 'en-US'));
    $('#timeInputChange').val(formatDate(examination.date, 'HH:mm', 'en-US'));
    
  }
























  

  

  onChange(inType): void {
    this.examination.interventionType = inType;
  }

  

  checkSpecialisation() {
    this.specialisationChecked = true;
    //TODO: ovde ce se pozivati listanje cena na osnovu tipa intervencije i specijalizacije koju korisnik odabere
  }





















  /**
   * open popup dialog on button click
   */
  openDialog(): void {
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: {name: this.name, animal: this.animal}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.animal = result;
    });
  }

}

/**
 * Angular popup dialog component
 */
@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: './dialog-overview-example-dialog.html',
})
export class DialogOverviewExampleDialog {

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}


