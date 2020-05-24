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

import { FormsModule } from '@angular/forms';
import { UserPageComponent } from './components/user-page/user-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DisplayClinicsComponent } from './components/patient/display-clinics/display-clinics.component';
import { ListClinicsService } from './services/patient/clinics/list-clinics.service';
import { AddDoctorComponent } from './components/add-doctor/add-doctor.component';
import { AddMedicalRoomComponent } from './components/add-medical-room/add-medical-room.component';
import { UserProfileService } from './services/user-profile-service/user-profile.service';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { MedicalRecordsService } from './services/patient/medical-records/medical-records.service';
import { MedicalRecordsComponent } from './components/patient/medical-records/medical-records.component';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { LoginComponent } from './components/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
// MDB Angular Free
import { CheckboxModule, WavesModule, ButtonsModule, InputsModule, IconsModule, CardsModule } from 'angular-bootstrap-md';
import { RegisterComponent } from './components/register/register.component';
import { AddExaminationTypeComponent } from './components/add-examination-type/add-examination-type.component';
import { TableOfPatientComponent } from './components/nurse/table-of-patient/table-of-patient.component';


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
    TableOfPatientComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgwWowModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    MatRadioModule, MatSelectModule, MatCardModule, MatCheckboxModule, MatSliderModule, MatButtonModule,
    ReactiveFormsModule,
    CheckboxModule, WavesModule, ButtonsModule, InputsModule, IconsModule, CardsModule
  ],
  providers: [ ListClinicsService, UserProfileService, MedicalRecordsService],  // Services go here because of DI
  bootstrap: [AppComponent]
})
export class AppModule { }
