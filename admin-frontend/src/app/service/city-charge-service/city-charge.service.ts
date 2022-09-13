import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {DistanceCharge} from "../../model/distance-charge-model/distance-charge";
import {Observable} from "rxjs";
import {CityCharge} from "../../model/city-charge-model/city-charge";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class CityChargeService {

  constructor(private httpClient : HttpClient) { }

  saveCityCharge(cityCharge : CityCharge): Observable<CityCharge>{
    return  this.httpClient.post<CityCharge>(apiURL+"city-charge", cityCharge);
  }
}
