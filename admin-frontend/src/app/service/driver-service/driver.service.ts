import {Injectable} from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Driver} from "../../model/driver-model/driver";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private httpClient: HttpClient) {
  }

  saveDriver(driver: Driver): Observable<Driver> {

    let formData = new FormData();
    Object.entries(driver).forEach(
      ([key, value]) => formData.append(key, value)
    );

    console.log("Form data  --  " + formData)

    return this.httpClient.post<Driver>(apiURL + "driver", formData);
  }

}
