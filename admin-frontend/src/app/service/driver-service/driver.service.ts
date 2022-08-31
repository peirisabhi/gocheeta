import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Driver} from "../../model/driver-model/driver";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private httpClient : HttpClient) {
  }

  saveDriver(driver : Driver): Observable<Driver>{
    return  this.httpClient.post<Driver>(apiURL+"driver", driver);
  }

}
