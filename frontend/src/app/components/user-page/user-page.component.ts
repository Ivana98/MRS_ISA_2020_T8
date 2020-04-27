import { Component, OnInit, Input, ViewChild, AfterViewInit, NgModule, HostListener } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomePageComponent } from '../home-page/home-page.component';
import { AddEmployeeComponent } from '../add-employee/add-employee.component';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { SomeLogicService } from 'src/app/some-logic.service';

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

  // constructor(private route: ActivatedRoute) { }

  // ngOnInit(): void {
  //   /* First way to retrieve data */
  //   this.sub = this.route.snapshot.paramMap.get('id');
  //   /* second way to retreive data */
  //   this.route.params.subscribe(params => {
  //     this.message = params['id'];
  //   });
  // }
  @ViewChild(MdbTableDirective, { static: true }) mdbTable:
MdbTableDirective; elements: any = []; headElements = ['ID', 'First',
'Last', 'Handle']; searchText: string = ''; previous: string;
constructor( private _someLogic: SomeLogicService) { } @HostListener('input') oninput() { this.searchItems();
} ngOnInit() {
  console.log("Aha2");
    this._someLogic._user$.subscribe(
      message => {
        if (message === 'PACIJENT') {
          alert('PACIJENT!');
        } else if (message === 'Well Done') {
          alert('Thank you Teacher!');
        }
      }
    )
  
  for (let i = 1; i <= 10; i++) { this.elements.push({ id:
i.toString(), first: 'Wpis' + (Math.floor(Math.random() * i *
10)).toString(), last: 'Last' + (Math.floor(Math.random() * i *
10)).toString(), handle: 'Handle' + (Math.floor(Math.random() * i *
10)).toString() }); } this.mdbTable.setDataSource(this.elements);
this.previous = this.mdbTable.getDataSource(); } searchItems() { const
prev = this.mdbTable.getDataSource(); if (!this.searchText) {
this.mdbTable.setDataSource(this.previous); this.elements =
this.mdbTable.getDataSource(); } if (this.searchText) { this.elements =
this.mdbTable.searchLocalDataByMultipleFields(this.searchText, ['first',
'last']); this.mdbTable.setDataSource(prev); } }

}
