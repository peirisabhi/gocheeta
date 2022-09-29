import {Component, OnInit} from '@angular/core';
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {VehicleAvailabilityService} from "../../service/vehicle-availability-service/vehicle-availability.service";
import {VehicleAvailability} from "../../model/vehicle-availability-model/vehicle-availability";
import {Booking} from "../../model/booking-model/booking";
import {NotificationService} from "../../service/notification-service/notification.service";
import {BookingService} from "../../service/booking-service/booking.service";
import {NgxSpinnerService} from "ngx-spinner";
import {Confirm, Report} from "notiflix";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-ride',
  templateUrl: './ride.component.html',
  styleUrls: ['./ride.component.css']
})
export class RideComponent implements OnInit {

  cities?: City[];
  vehicleCategories?: VehicleCategory[];
  vehicleAvailability: VehicleAvailability = new VehicleAvailability();
  booking: Booking = new Booking();

  price?: string = "0.00"
  km?: string = "0";

  condition: boolean = false;
  vehicleAvailabilityStatus: boolean = false;


  constructor(private cityService: CityService,
              private vehicleCategoryService: VehicleCategoryService,
              private vehicleAvailabilityService: VehicleAvailabilityService,
              private notificationService: NotificationService,
              private bookingService: BookingService,
              private spinnerService: NgxSpinnerService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.getCities()
    this.getVehicleCategories()


  }

  // public showSpinner(): void {
  //   this.spinnerService.show();
  //
  //   setTimeout(() => {
  //     this.spinnerService.hide();
  //   }, 5000); // 5 seconds
  // }


  getCities() {
    this.cityService.getCities().subscribe(data => {
      this.cities = data;
    }, error => {
      console.log(error)
    })
  }

  getVehicleCategories() {
    this.vehicleCategoryService.getVehicleCategories().subscribe(data => {
      this.vehicleCategories = data;
    }, error => {
      console.log(error)
    })
  }

  checkAvailability() {


    if (this.vehicleAvailability.from_city != 0
      && this.vehicleAvailability.to_city != 0
      && this.vehicleAvailability.vehicle_category != 0) {

      this.spinnerService.show();

      this.vehicleAvailabilityService.getAvailability(this.vehicleAvailability).subscribe(data => {
        console.log(data)

        if (data.availability) {
          this.price = data.price;
          this.vehicleAvailability.time_duration = data.time_duration;
          this.spinnerService.hide();
          this.vehicleAvailabilityStatus = true;
        } else {
          this.price = "0.00";
          this.vehicleAvailability.time_duration = "0";
          this.spinnerService.hide();
          this.vehicleAvailabilityStatus = false;
          this.notificationService.showError("No riders are currently available", "Booking Unavailable")
        }

      }, error => {
        console.log(error)
      })
    }
  }

  saveBooking() {

    if (!this.condition) {
      Report.warning(
        'Warning',
        'Please accept Terms & Condition!',
        'Okay',);
    } else {

      Confirm.show(
        'Confirm',
        'Do you want to book?',
        'Yes', 'No',
        () => {

          this.spinnerService.show();

          this.booking.from_city = this.vehicleAvailability.from_city;
          this.booking.to_city = this.vehicleAvailability.to_city;
          this.booking.vehicle_category = this.vehicleAvailability.vehicle_category;
          this.booking.date = this.vehicleAvailability.date;
          this.booking.time = this.vehicleAvailability.time;

          this.bookingService.saveBooking(this.booking)
            .subscribe(data => {
                console.log(data)
                this.spinnerService.hide();

                this.router.navigate(['/booking-success'],
                  {
                    state: {
                      booking: data,
                    }
                  });

              },
              error => {
                console.log(error)
                this.spinnerService.hide();

                Report.failure(
                  'Error',
                  'Something went wrong please, please try again later',
                  'Okay',);

              });

        });
    }
  }

}
