import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

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

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    DemoV2Component,
    PageNotFoundComponent,
    DemoV3Component,
    AddEmployeeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgwWowModule,
    FormsModule
  ],
  providers: [HttpDemoService],  // Services go here because of DI
  bootstrap: [AppComponent]
})
export class AppModule { }
