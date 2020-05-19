import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { DisplayClinicsComponent } from './components/patient/display-clinics/display-clinics.component';
import { AddDoctorComponent } from './components/add-doctor/add-doctor.component';
import { AddMedicalRoomComponent } from './components/add-medical-room/add-medical-room.component';
import { RegistrationClinicAdminComponent } from './components/clinical-center-administrator/registration-clinic-admin/registration-clinic-admin.component'
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { MedicalRecordsComponent } from './components/patient/medical-records/medical-records.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AddExaminationTypeComponent } from './components/add-examination-type/add-examination-type.component';
import { GuestGuard } from './guard/guest.guard';
import { LoginGuard } from './guard/login.guard';
import { PageForbiddenComponent } from './components/page-forbidden/page-forbidden.component';
import { PatientGuard } from './guard/patient.guard';
import { ClinicCenterAdminGuard } from './guard/clinic-center-admin.guard';

const routes: Routes = [
  { path: '', redirectTo: 'homepage', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'homepage', component: HomePageComponent },
  { path: 'login', component: LoginComponent, canActivate: [GuestGuard] },
  { path: 'register', component: RegisterComponent, canActivate: [GuestGuard] },
  { path: 'user-page', component: UserPageComponent, canActivate: [LoginGuard],
    children: [
      { path: 'addDoctor', component: AddDoctorComponent },
      { path: 'addMedicalRoom', component: AddMedicalRoomComponent },
      { path: 'clinicsTable', component: DisplayClinicsComponent, canActivate: [PatientGuard] },
      { path: 'registrationClinicAdmin', component: RegistrationClinicAdminComponent, canActivate: [ClinicCenterAdminGuard] },
      { path: 'myProfile', component: UserProfileComponent, canActivate: [LoginGuard] },
      { path: 'medicalRecords', component: MedicalRecordsComponent, canActivate: [PatientGuard] },
      { path: 'addExaminationType', component: AddExaminationTypeComponent }
    ]
  },
  { path: '403', component: PageForbiddenComponent},
  { path: '404', component: PageNotFoundComponent},
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomePageComponent, AddEmployeeComponent, 
  UserPageComponent, AddDoctorComponent, AddMedicalRoomComponent, DisplayClinicsComponent,
  RegistrationClinicAdminComponent, LoginComponent,
  RegisterComponent, AddExaminationTypeComponent, MedicalRecordsComponent]
