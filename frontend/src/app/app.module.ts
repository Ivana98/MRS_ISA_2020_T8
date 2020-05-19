import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { RouterModule } from '@angular/router';
import { MatSliderModule } from '@angular/material/slider';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgwWowModule } from 'ngx-wow';
import { DemoV2Component } from './components/demo-v2/demo-v2.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
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
import { LoginService } from './services/login-service/login.service';
import { AuthService } from './services/authService/auth.service';
import { ApiService } from './services/api-services/api.service';
import { TokenInterceptor } from './interceptor/TokenInterceptor';
import { GuestGuard } from './guard/guest.guard';
import { LoginGuard } from './guard/login.guard';
import { PatientGuard } from './guard/patient.guard';
import { DoctorGuard } from './guard/doctor.guard';
import { NurseGuard } from './guard/nurse.guard';
import { ClinicAdminGuard } from './guard/clinic-admin.guard';
import { ClinicCenterAdminGuard } from './guard/clinic-center-admin.guard';
import { PageForbiddenComponent } from './components/page-forbidden/page-forbidden.component';
import { ClinicInfoPageComponent } from './components/patient/clinic-info-page/clinic-info-page.component';
import { TransferClinicService } from './services/patient/clinics/transfer-clinic.service';


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
    MedicalRecordsComponent,
    LoginComponent,
    RegisterComponent,
    AddExaminationTypeComponent,
    PageForbiddenComponent,
    ClinicInfoPageComponent,
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
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    GuestGuard,
    LoginGuard,
    PatientGuard,
    DoctorGuard,
    NurseGuard,
    ClinicAdminGuard,
    ClinicCenterAdminGuard,
    HttpDemoService, 
    ListClinicsService, 
    UserProfileService, 
    MedicalRecordsService, 
    LoginService, 
    AuthService,
    ApiService,
    TransferClinicService
],  // Services go here because of DI
  bootstrap: [AppComponent]
})
export class AppModule { }
