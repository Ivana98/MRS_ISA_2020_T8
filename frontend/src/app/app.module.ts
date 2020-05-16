import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { RouterModule } from '@angular/router';
import { MatSliderModule } from '@angular/material/slider';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgwWowModule } from 'ngx-wow';
import { HttpClientModule } from '@angular/common/http';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { HttpDemoService } from './services/http_demo/http-demo.service';
import { FormsModule } from '@angular/forms';
import { UserPageComponent } from './components/user-page/user-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DisplayClinicsComponent } from './components/patient/display-clinics/display-clinics.component';
import { ListClinicsService } from './services/patient/clinics/list-clinics.service';
import { AddDoctorComponent } from './components/administrator/add-doctor/add-doctor.component';
import { AddMedicalRoomComponent } from './components/administrator/add-medical-room/add-medical-room.component';
import { UserProfileService } from './services/user-profile-service/user-profile.service';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { MedicalRecordsService } from './services/patient/medical-records/medical-records.service';
import { MedicalRecordsComponent } from './components/patient/medical-records/medical-records.component';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
// MDB Angular Free
import { CheckboxModule, WavesModule, ButtonsModule, InputsModule, IconsModule, CardsModule } from 'angular-bootstrap-md';
import { RegisterComponent } from './components/register/register.component';
import { DisplayDoctorsComponent } from './components/administrator/display-doctors/display-doctors.component';
import { AddExaminationTypeComponent } from './components/administrator/add-examination-type/add-examination-type.component';
import { ChangeDoctorComponent } from './components/administrator/change-doctor/change-doctor.component';
import { MatSortModule } from '@angular/material/sort';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
// import { MatMomentDateModule } from "@angular/material-moment-adapter";

// import { MatAutocompleteHarness } from '@angular/material/autocomplete/testing';
import { DisplayExaminationTypesComponent } from './components/administrator/display-examination-types/display-examination-types.component';
import { DisplayPatientsComponent } from './components/administrator/display-patients/display-patients.component';
import { NewAppointmentComponent } from './components/administrator/new-appointment/new-appointment.component';
import { DisplayMedicalRoomsComponent } from './components/administrator/display-medical-rooms/display-medical-rooms.component';
import { EditClinicBasicComponent } from './components/administrator/edit-clinic-basic/edit-clinic-basic.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    PageNotFoundComponent,
    DisplayClinicsComponent,
    UserPageComponent,
    AddDoctorComponent,
    AddMedicalRoomComponent,
    UserProfileComponent,
    MedicalRecordsComponent,
    LoginComponent,
    RegisterComponent,
    AddExaminationTypeComponent,
    DisplayDoctorsComponent,
    ChangeDoctorComponent,
    DisplayExaminationTypesComponent,
    DisplayPatientsComponent,
    NewAppointmentComponent,
    DisplayMedicalRoomsComponent,
    EditClinicBasicComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgwWowModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    MatRadioModule, MatSelectModule, MatCardModule, MatCheckboxModule, MatSliderModule, MatButtonModule, MatTableModule, 
    MatAutocompleteModule, MatInputModule, MatFormFieldModule, MatDatepickerModule, MatNativeDateModule, 
    ReactiveFormsModule, MatIconModule, 
    CheckboxModule, WavesModule, ButtonsModule, InputsModule, IconsModule, CardsModule,
    BrowserModule,
    MatSortModule
  ],
  providers: [HttpDemoService, ListClinicsService, UserProfileService, MedicalRecordsService],  // Services go here because of DI
  bootstrap: [AppComponent]
})
export class AppModule { }
