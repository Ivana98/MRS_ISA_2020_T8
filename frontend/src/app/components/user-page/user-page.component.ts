import { Component, OnInit, Input, ViewChild, AfterViewInit, NgModule, HostListener } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomePageComponent } from '../home-page/home-page.component';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { SomeLogicService } from 'src/app/some-logic.service';
import { AuthService } from 'src/app/services/authService/auth.service';
import { LoginService } from 'src/app/services/login-service/login.service';
declare var $: any;
// import $ from 'jquery';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  message:string;
  sub:string;
  role: string;

  userRole: string = "";

constructor(
  private _someLogic: SomeLogicService, 
  private _authService: AuthService,
  private _loginService: LoginService
  ) { } 

@HostListener('input') oninput() { } 

ngOnInit() {
  this.userRole = this._loginService.currentUser.userAuthority;
  this._someLogic._user$.subscribe(
    message => {
      if (message === 'PACIJENT') {
        alert('PACIJENT!');
      } else if (message === 'Well Done') {
        alert('Thank you Teacher!');
      }
    }
  )

  /* JQuery function for open and close side bar */
  $(function(){
    "use strict";
  
    var fullHeight = function() {
  
      $('.js-fullheight').css('height', $(window).height());
      $(window).resize(function(){
        $('.js-fullheight').css('height', $(window).height());
      });
  
    };
    fullHeight();
  
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
  
  });
}

logoutUser(){
  this._authService.logout();
}

}
