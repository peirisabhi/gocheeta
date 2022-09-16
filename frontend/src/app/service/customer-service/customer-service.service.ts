import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Customer} from "../../model/customer-model/customer";
import {Observable} from "rxjs";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private httpClient : HttpClient) { }

  saveCustomer(customer : Customer): Observable<Customer>{
    return  this.httpClient.post<Customer>(apiURL+"customer", customer);
  }
}
