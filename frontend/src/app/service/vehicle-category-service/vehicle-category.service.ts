import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class VehicleCategoryService {

  constructor(private httpClient : HttpClient) { }

  getVehicleCategories(): Observable<VehicleCategory[]>{
    return this.httpClient.get<VehicleCategory[]>(apiURL + 'vehicle-category');
  }

  getVehicleCategory(vehicleCategoryId: number): Observable<VehicleCategory[]>{
    return this.httpClient.get<VehicleCategory[]>(apiURL + 'vehicle-category/'+vehicleCategoryId);
  }


}
