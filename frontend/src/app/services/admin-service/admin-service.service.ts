import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IAdmin } from 'src/app/model/admin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  private _get_ulr: string = "http://localhost:8080/getAll";
  private _save_ulr: string = "http://localhost:8080/addOne";

  constructor(private _httpClient:HttpClient) {  }

  getAll():Observable<Array<IAdmin>>
  {
    return this._httpClient.get<Array<IAdmin>>(this._get_ulr);
  }

  public addOne(admin) {
    // console.log("PODACI PRE")
    // console.log(admin.name);
    // console.log(admin.pass);
    
    return this._httpClient.post<IAdmin>(this._save_ulr, admin);
  }
}
