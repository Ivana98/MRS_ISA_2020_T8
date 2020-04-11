import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Employee // TODO: delete this and create interface ??
{
  constructor(
    public empId:string,
    public name:string,
    public designation:string,
    public salary:string,
  ) {}
}

@Injectable({
  providedIn: 'root'
})
export class HttpDemoService {

  private _ulr: string = "http://localhost:8080/employees";

  constructor(private _httpClient:HttpClient) {  }

  getEmployees()
  {
    console.log("We establish call");
    return this._httpClient.get<Employee[]>(this._ulr);
  }
}
