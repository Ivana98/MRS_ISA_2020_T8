import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgwWowModule } from 'ngx-wow';
import { DemoV2Component } from './demo-v2/demo-v2.component';
import { HttpClientModule } from '@angular/common/http';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HttpDemoService } from './service/http-demo.service';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    DemoV2Component,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgwWowModule
  ],
  providers: [HttpDemoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
