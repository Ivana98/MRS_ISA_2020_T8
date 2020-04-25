import { Component, OnInit, Input, ViewChild, AfterViewInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomePageComponent } from '../home-page/home-page.component';
import { AddEmployeeComponent } from '../add-employee/add-employee.component';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  message:string;
  sub:string;

  // @ViewChild(HomePageComponent) childReference;

  // exampleParent: string;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    /* First way to retrieve data */
    this.sub = this.route.snapshot.paramMap.get('id');
    /* second way to retreive data */
    this.route.params.subscribe(params => {
      this.message = params['id'];
    });
  }

  // ngAfterViewInit() {
  //   this.exampleParent = this.childReference.exampleChild;
  // }

}
