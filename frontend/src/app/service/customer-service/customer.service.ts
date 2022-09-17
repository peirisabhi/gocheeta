import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "../../model/customer-model/customer";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient : HttpClient) { }

  saveCustomer(customer : Customer): Observable<Customer>{
    return  this.httpClient.post<Customer>(apiURL+"customer/save", customer);
  }
}
