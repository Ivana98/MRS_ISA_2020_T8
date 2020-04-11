import { Component, OnInit } from '@angular/core';
import { HttpDemoService } from '../service/http-demo.service';

@Component({
  selector: 'app-demo-v2',
  templateUrl: './demo-v2.component.html',
  styleUrls: ['./demo-v2.component.css']
})
export class DemoV2Component implements OnInit {

  public employees:string[];

  constructor(private _httpDemoService: HttpDemoService) { }

  ngOnInit(): void {
    // this._httpDemoService.getEmployees().subscribe(response => this.employees = response); 
    this._httpDemoService.getEmployees().subscribe(response => this.handleSuccessfulResponse(response));
  }

  handleSuccessfulResponse( r )
  {
    this.employees = r;
  }

}
