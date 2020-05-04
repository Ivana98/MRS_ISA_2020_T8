import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { RouterModule } from '@angular/router';
import { MatSliderModule } from '@angular/material/slider';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgwWowModule } from 'ngx-wow';
import { DemoV2Component } from './components/demo-v2/demo-v2.component';
import { HttpClientModule } from '@angular/common/http';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { HttpDemoService } from './services/http_demo/http-demo.service';
import { DemoV3Component } from './components/demo-v3/demo-v3.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
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

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    DemoV2Component,
    PageNotFoundComponent,
    DemoV3Component,
    AddEmployeeComponent,
    DisplayClinicsComponent,
    UserPageComponent,
    AddDoctorComponent,
    AddMedicalRoomComponent,
    UserProfileComponent,
    MedicalRecordsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgwWowModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    MatSliderModule,
  ],
  providers: [HttpDemoService, ListClinicsService, UserProfileService, MedicalRecordsService],  // Services go here because of DI
  bootstrap: [AppComponent]
})
export class AppModule { }
