import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {DistanceCharge} from "../../model/distance-charge-model/distance-charge";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class DistanceChargeService {

  constructor(private httpClient : HttpClient) { }

  saveDistanceCharge(distanceCharge : DistanceCharge): Observable<DistanceCharge>{
    return  this.httpClient.post<DistanceCharge>(apiURL+"distance-charge", distanceCharge);
  }
}
