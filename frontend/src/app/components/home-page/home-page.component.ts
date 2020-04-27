import { Component, OnInit } from '@angular/core';
import { NgwWowService } from 'ngx-wow';
import { DataService } from 'src/app/services/data-service/data.service';
import { ActivatedRoute, ActivatedRouteSnapshot, Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private wowService: NgwWowService, private router: Router) { 
    //Pokrece animacije
    this.wowService.init(); 
  } 

  message:string = "jajaja"; //for first way
  message2:string = "Op cup"; //for second way
  exampleChild: string = "Hello angular hehe"; //third way

  ngOnInit(): void {
  }

  salji(): void {
    /* First way to share data */
    this.router.navigate(['/homepage/user-page', this.message]);
  }

}
