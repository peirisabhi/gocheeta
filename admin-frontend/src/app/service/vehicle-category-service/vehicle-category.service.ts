import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {LicenceType} from "../../model/licence-type-model/licence-type";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class VehicleCategoryService {

  constructor(private httpClient : HttpClient) { }

  saveVehicleCategory(vehicleCategory : VehicleCategory): Observable<VehicleCategory>{
    return  this.httpClient.post<VehicleCategory>(apiURL+"vehicle-category", vehicleCategory);
  }


  updateVehicleCategory(vehicleCategory : VehicleCategory): Observable<VehicleCategory>{
    return  this.httpClient.put<VehicleCategory>(apiURL+"vehicle-category", vehicleCategory);
  }


  getVehicleCategories(): Observable<VehicleCategory[]>{
    return this.httpClient.get<VehicleCategory[]>(apiURL + 'vehicle-category');
  }


  getVehicleCategory(id:any): Observable<VehicleCategory>{
    return this.httpClient.get<VehicleCategory>(apiURL + 'vehicle-category/'+ id);
  }
}
