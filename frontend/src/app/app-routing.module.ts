import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { DemoV2Component } from './components/demo-v2/demo-v2.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { DemoV3Component } from './components/demo-v3/demo-v3.component';
import { AddEmployeeComponent } from './components/add-employee/add-employee.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UserPageComponent } from './components/user-page/user-page.component';

const routes: Routes = [
  { path: '', redirectTo: 'homepage', pathMatch: 'full' }, // Don't use prefix becasue empty path is a prefix to any path
  { path: 'homepage', component: HomePageComponent },
  { path: 'demov2', component: DemoV2Component },
  { path: 'demov3', component: DemoV3Component },
  { path: 'homepage/adde', component: AddEmployeeComponent },
  { path: 'userprofile', component: UserProfileComponent },
  { path: 'homepage/user-page/:id', component: UserPageComponent },
  { path: 'homepage/user-page', component: UserPageComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomePageComponent, DemoV2Component, 
  DemoV3Component, AddEmployeeComponent, UserProfileComponent, UserPageComponent]