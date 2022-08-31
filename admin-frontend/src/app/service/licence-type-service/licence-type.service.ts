import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LicenceType} from "../../model/licence-type-model/licence-type";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class LicenceTypeService {

  constructor(private httpClient : HttpClient) { }

  getLicenceTypes(): Observable<LicenceType[]>{
    return this.httpClient.get<LicenceType[]>(apiURL + 'licence-type');
  }
}
