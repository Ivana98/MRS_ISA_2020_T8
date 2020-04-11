import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IEmployee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class HttpDemoService {

  private _ulr: string = "http://localhost:8080/employees";

  constructor(private _httpClient:HttpClient) {  }

  getEmployees()
  {
    console.log("We establish call");
    return this._httpClient.get<IEmployee[]>(this._ulr);
  }
}
