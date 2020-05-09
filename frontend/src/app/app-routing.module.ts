import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { DisplayClinicsComponent } from './components/patient/display-clinics/display-clinics.component';
import { AddDoctorComponent } from './components/administrator/add-doctor/add-doctor.component';
import { AddMedicalRoomComponent } from './components/administrator/add-medical-room/add-medical-room.component';
import { RegistrationClinicAdminComponent } from './components/clinical-center-administrator/registration-clinic-admin/registration-clinic-admin.component'
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { MedicalRecordsComponent } from './components/patient/medical-records/medical-records.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { DisplayDoctorsComponent } from './components/administrator/display-doctors/display-doctors.component';
import { AddExaminationTypeComponent } from './components/administrator/add-examination-type/add-examination-type.component';
import { ChangeDoctorComponent } from './components/administrator/change-doctor/change-doctor.component';
import { DisplayExaminationTypesComponent } from './components/administrator/display-examination-types/display-examination-types.component';
import { DisplayPatientsComponent } from './components/administrator/display-patients/display-patients.component';

const routes: Routes = [
  { path: '', redirectTo: 'homepage', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'homepage', component: HomePageComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  // { path: 'changeDoctor2', component: ChangeDoctorComponent },
  { path: 'user-page', component: UserPageComponent,
    children: [
      { path: 'addDoctor', component: AddDoctorComponent },
      { path: 'addMedicalRoom', component: AddMedicalRoomComponent },
      { path: 'clinicsTable', component: DisplayClinicsComponent},
      { path: 'registrationClinicAdmin', component: RegistrationClinicAdminComponent },
      { path: 'myProfile', component: UserProfileComponent},
      { path: 'medicalRecords', component: MedicalRecordsComponent},
      { path: 'addExaminationType', component: AddExaminationTypeComponent },
      { path: 'displayDoctors', component: DisplayDoctorsComponent, 
        children: [
          { path: 'changeDoctor', component: ChangeDoctorComponent }
        ]
      },
      { path: "displayExaminationTypes", component: DisplayExaminationTypesComponent },
      { path: "displayPatients", component: DisplayPatientsComponent }
    ]
  },
 
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [
  HomePageComponent,
  UserPageComponent, AddDoctorComponent, AddMedicalRoomComponent, DisplayClinicsComponent,
  RegistrationClinicAdminComponent, LoginComponent, DisplayDoctorsComponent, DisplayExaminationTypesComponent,
  RegisterComponent, AddExaminationTypeComponent, MedicalRecordsComponent, ChangeDoctorComponent, 
  DisplayPatientsComponent
]
