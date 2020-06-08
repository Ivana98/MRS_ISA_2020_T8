import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { RouterModule } from '@angular/router';
import { MatSliderModule } from '@angular/material/slider';
import { ChartsModule } from 'angular-bootstrap-md'

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgwWowModule } from 'ngx-wow';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
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
import { DisplayDoctorsComponent } from './components/administrator/display-doctors/display-doctors.component';
import { ChangeDoctorComponent } from './components/administrator/change-doctor/change-doctor.component';
import { MatSortModule } from '@angular/material/sort';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDividerModule } from '@angular/material/divider';
// import { MatMomentDateModule } from "@angular/material-moment-adapter";

// import { MatAutocompleteHarness } from '@angular/material/autocomplete/testing';
import { DisplayExaminationTypesComponent } from './components/administrator/display-examination-types/display-examination-types.component';
import { DisplayPatientsComponent } from './components/administrator/display-patients/display-patients.component';
import { NewAppointmentComponent } from './components/administrator/new-appointment/new-appointment.component';
import { DisplayMedicalRoomsComponent } from './components/administrator/display-medical-rooms/display-medical-rooms.component';
import { EditClinicBasicComponent } from './components/administrator/edit-clinic-basic/edit-clinic-basic.component';
import { TableOfPatientComponent } from './components/nurse/table-of-patient/table-of-patient.component';
import { AddExaminationTypeComponent } from './components/administrator/add-examination-type/add-examination-type.component';
import { DisplayReportComponent } from './components/administrator/display-report/display-report.component';
import { CalendarComponent } from './components/administrator/calendar/calendar.component';
import { AbsenceComponent } from './components/doctor/absence/absence.component';
import { RequestService } from './services/request-service/request.service';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { ChangePasswordGuard } from './guard/change-password.guard';


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
    PageForbiddenComponent,
    ClinicInfoPageComponent,
    DisplayDoctorsComponent,
    ChangeDoctorComponent,
    DisplayExaminationTypesComponent,
    DisplayPatientsComponent,
    NewAppointmentComponent,
    DisplayMedicalRoomsComponent,
    EditClinicBasicComponent,
    TableOfPatientComponent,
    DisplayReportComponent,
    CalendarComponent,
    AbsenceComponent,
    ChangePasswordComponent
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
    MatAutocompleteModule, MatInputModule, MatFormFieldModule, MatDatepickerModule, MatNativeDateModule, MatDividerModule, 
    ReactiveFormsModule, MatIconModule, MatDialogModule, MatRippleModule,
    CheckboxModule, WavesModule, ButtonsModule, InputsModule, IconsModule, CardsModule,
    BrowserModule, ChartsModule,
    MatSortModule
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
    ChangePasswordGuard,
    ListClinicsService, 
    UserProfileService, 
    MedicalRecordsService, 
    LoginService, 
    AuthService,
    ApiService,
    TransferClinicService,
    RequestService
],  // Services go here because of DI
  bootstrap: [AppComponent]
})
export class AppModule { }
