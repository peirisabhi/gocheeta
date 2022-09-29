import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {map} from "rxjs";

@Component({
  selector: 'app-booking-success',
  templateUrl: './booking-success.component.html',
  styleUrls: ['./booking-success.component.css']
})
export class BookingSuccessComponent implements OnInit {

  bookingId?: string;
  vehicleCategory?: string;
  pickupCity?: string;
  pickupStreet?: string;
  dropOffCity?: string;
  dropOffStreet?: string;
  vehicleNo?: string;
  driver?: string;
  date?: string;
  time?: string;
  endTime?: string;

  constructor(private route: ActivatedRoute, private router: Router) {
    // @ts-ignore
    let data = this.router.getCurrentNavigation().extras.state.booking;
    console.log(data);

    this.bookingId = data.id;
    this.vehicleCategory = data.vehicle_category_val;
    this.pickupCity = data.from_city_val;
    this.pickupStreet = data.pick_up_street;
    this.dropOffCity = data.to_city_val;
    this.dropOffStreet = data.drop_off_street;
    this.date = data.date;
    this.time = data.time;
    this.vehicleNo = data.vehicle_no;
    this.driver = data.driver;
    this.endTime = data.end_time;
  }

  ngOnInit(): void {

  }

}
