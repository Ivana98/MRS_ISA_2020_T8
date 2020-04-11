import { Component, OnInit } from '@angular/core';
import { NgwWowService } from 'ngx-wow';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private wowService: NgwWowService) { 
    //Pokrece animacije
    this.wowService.init(); 
  } 

  ngOnInit(): void {
  }

}
