import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Price, FullPrice } from 'src/app/model/price';
import { LoginService } from '../login-service/login.service';
import { url } from 'inspector';

@Injectable({
  providedIn: 'root'
})
export class PriceService {

  private _url: string = "http://localhost:8080/api/prices/";

  constructor(private _httpClient: HttpClient, private _loginService: LoginService) { }

  public getOne(priceId) {
    return this._httpClient.get<Price>(this._url + "getOne/" + priceId);
  }

  /**
   * Load all examination types and prices from pricelist.
   * 
   * @param clinicId is id of logged in user clinic
   */
  public loadAllByClinicId() {
    return this._httpClient.get<Array<FullPrice>>(this._url + "getAllFromClinic/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Modify examination type (price).
   * 
   * @param et if FullPrice
   */
  public update(et) {
    return this._httpClient.put<FullPrice>(this._url + "modify", et);
  }

  /**
   * Delete examination type (price).
   * 
   * @param id is price id
   */
  public delete(id) {
    return this._httpClient.delete(this._url + "delete/" + id);
  }
}
