import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SomeLogicService {

  private _userType = new Subject<string>();
  _user$ = this._userType.asObservable();

  sentType(message: string) {
    //console.log("USAO");
    this._userType.next(message);
  }

  constructor() { }
}
