import { Component, OnInit } from '@angular/core';
import { IEmployee, Employee } from 'src/app/model/employee';
import { HttpDemoService } from 'src/app/services/http_demo/http-demo.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  user: IEmployee = new Employee("","","","");

  constructor(
    private httpClientService: HttpDemoService
  ) { }

  ngOnInit() {
  }

  createEmployee(): void {
    this.httpClientService.createEmployee(this.user)
        .subscribe( data => {
          alert("Employee created successfully.");
        });

  };

}
