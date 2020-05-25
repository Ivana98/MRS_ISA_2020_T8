import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Price, FullPrice } from 'src/app/model/price';

@Injectable({
  providedIn: 'root'
})
export class PriceService {

  private _url: string = "http://localhost:8080/api/prices/";

  constructor(private _httpClient: HttpClient) { }

  public getOne(priceId) {
    return this._httpClient.get<Price>(this._url + "getOne/" + priceId);
  }

  /**
   * Load all examination types and prices from pricelist.
   * 
   * @param clinicId is id of logged in user clinic
   */
  public loadAllByClinicId(clinicId) {
    return this._httpClient.get<Array<FullPrice>>(this._url + "getAllFromClinic/" + clinicId);
  }
}
