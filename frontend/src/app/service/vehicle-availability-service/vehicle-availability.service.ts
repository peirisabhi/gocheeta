import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {City} from "../../model/city-model/city";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {VehicleAvailability} from "../../model/vehicle-availability-model/vehicle-availability";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class VehicleAvailabilityService {

  constructor(private httpClient : HttpClient) { }


  getAvailability(vehicleAvailability: VehicleAvailability): Observable<VehicleAvailability>{
    return this.httpClient.post<VehicleAvailability>(apiURL + 'vehicle/availability', vehicleAvailability);
  }

  saveCity(city : City): Observable<City>{
    return  this.httpClient.post<City>(apiURL+"city", city);
  }
}
