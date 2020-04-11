import { Component, OnInit } from '@angular/core';
import { HttpDemoService } from '../../services/http_demo/http-demo.service';
import { IEmployee } from 'src/app/model/employee';

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

  deleteEmployee(employee: IEmployee): void {
    this._httpDemoService.deleteEmployee(employee)
      .subscribe( data => {
        this.employees = this.employees.filter(u => u !== employee.empId); //Added .empId
      })
  };

}
