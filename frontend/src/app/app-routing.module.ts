import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DemoVComponent } from './demo-v/demo-v.component';


const routes: Routes = [
  {path: 'demov', component: DemoVComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [DemoVComponent]