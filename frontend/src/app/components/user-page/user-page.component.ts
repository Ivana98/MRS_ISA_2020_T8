import { Component, OnInit, Input, ViewChild, AfterViewInit, NgModule, HostListener } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomePageComponent } from '../home-page/home-page.component';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { SomeLogicService } from 'src/app/some-logic.service';
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

constructor( private _someLogic: SomeLogicService) { } @HostListener('input') oninput() { } 
ngOnInit() {
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

}
