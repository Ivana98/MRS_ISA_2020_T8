import { Component, OnInit } from '@angular/core';
import { HttpDemoService } from '../../services/http_demo/http-demo.service';
import { IEmployee } from 'src/app/model/employee';

@Component({
  selector: 'app-demo-v3',
  templateUrl: './demo-v3.component.html',
  styleUrls: ['./demo-v3.component.css']
})
export class DemoV3Component implements OnInit {

  public employees:IEmployee[];

  constructor(private _httpDemoService: HttpDemoService) { }

  ngOnInit(): void {
    this._httpDemoService.getEmployees().subscribe(response => this.handleSuccessfulResponse(response));
  }

  handleSuccessfulResponse( r )
  {
    this.employees = r;
  }

  deleteEmployee(employee: IEmployee): void {
    this._httpDemoService.deleteEmployee(employee)
      .subscribe( data => {
        /*
        * First way
        */
        this.employees = this.employees.filter(u => u !== employee);
        
        /*
        * Second way, but must be public employees:String[]; 
        */
        // for (let e of this.employees) {
        //   if (e.empId == employee.empId) {
        //       this.employees.splice(this.employees.indexOf(e), 1);
        //       break;
        //   }      
        // }
      })
  };

}
