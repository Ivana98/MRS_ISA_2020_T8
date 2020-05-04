import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { DisplayClinicsComponent } from './components/patient/display-clinics/display-clinics.component';
import { AddDoctorComponent } from './components/add-doctor/add-doctor.component';
import { AddMedicalRoomComponent } from './components/add-medical-room/add-medical-room.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { MedicalRecordsComponent } from './components/patient/medical-records/medical-records.component';

const routes: Routes = [
  { path: '', redirectTo: 'homepage', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'homepage', component: HomePageComponent},
  //{ path: 'homepage/adde', component: AddEmployeeComponent},
  //{ path: 'addDoctor', component: AddDoctorComponent },
  //{ path: 'homepage/user-page/:id', component: UserPageComponent },
  { path: 'user-page', component: UserPageComponent,
    children: [
      { path: 'addDoctor', component: AddDoctorComponent },
      { path: 'addMedicalRoom', component: AddMedicalRoomComponent },
      { path: 'clinicsTable', component: DisplayClinicsComponent},
      { path: 'myProfile', component: UserProfileComponent},
      { path: 'medicalRecords', component: MedicalRecordsComponent}
    ]
  },
 
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomePageComponent, AddEmployeeComponent, 
  UserPageComponent, AddDoctorComponent, AddMedicalRoomComponent, DisplayClinicsComponent, MedicalRecordsComponent]
