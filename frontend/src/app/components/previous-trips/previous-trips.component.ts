import { Component, OnInit } from '@angular/core';
import {Booking} from "../../model/booking-model/booking";
import {BookingService} from "../../service/booking-service/booking.service";
import {StorageService} from "../../service/storage-service/storage.service";

@Component({
  selector: 'app-previous-trips',
  templateUrl: './previous-trips.component.html',
  styleUrls: ['./previous-trips.component.css']
})
export class PreviousTripsComponent implements OnInit {

  bookings: Booking[] = [];
  loggedUsersId?: string;

  constructor(private bookingService: BookingService,
              private storageService: StorageService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.loggedUsersId = this.storageService.getUser().data.id;
      this.loadBookings()
    }
  }

  loadBookings(){
    if (this.loggedUsersId != null) {
      this.bookingService.getBookings(this.loggedUsersId).subscribe(data => {
        this.bookings = data;
        console.log(data);
      })
    }
  }

}
