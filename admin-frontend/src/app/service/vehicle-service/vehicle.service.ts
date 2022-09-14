import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Vehicle} from "../../model/vehicle-model/vehicle";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private httpClient : HttpClient) { }

  saveVehicle(vehicle : Vehicle): Observable<Vehicle>{
    return  this.httpClient.post<Vehicle>(apiURL+"vehicle", vehicle);
  }
}
