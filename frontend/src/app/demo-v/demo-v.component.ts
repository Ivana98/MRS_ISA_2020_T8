import { Component, OnInit } from '@angular/core';
import { NgwWowService } from 'ngx-wow';

@Component({
  selector: 'app-demo-v',
  templateUrl: './demo-v.component.html',
  styleUrls: ['./demo-v.component.css']
})
export class DemoVComponent implements OnInit {

  constructor(private wowService: NgwWowService) { 
    //Pokrece animacije
    this.wowService.init(); 
  } 

  ngOnInit(): void {
  }

}
