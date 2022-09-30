import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Booking} from "../../model/booking-model/booking";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private httpClient : HttpClient) { }

  saveBooking(booking : Booking): Observable<Booking>{
    return  this.httpClient.post<Booking>(apiURL+"booking", booking);
  }

  getBookings(customerId: string): Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(apiURL + 'booking/'+customerId);
  }
}
