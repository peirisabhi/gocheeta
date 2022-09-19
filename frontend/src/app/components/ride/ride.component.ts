import {Component, OnInit} from '@angular/core';
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {VehicleAvailabilityService} from "../../service/vehicle-availability-service/vehicle-availability.service";
import {VehicleAvailability} from "../../model/vehicle-availability-model/vehicle-availability";
import {Booking} from "../../model/booking-model/booking";
import {formatDate} from "@angular/common";
import {NotificationService} from "../../service/notification-service/notification.service";

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
  date?: string;

  price?: string = "0.00"
  km?: string = "0";


  constructor(private cityService: CityService,
              private vehicleCategoryService: VehicleCategoryService,
              private vehicleAvailabilityService: VehicleAvailabilityService,
              private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this.getCities()
    this.getVehicleCategories()
    console.log(formatDate(new Date(), 'dd/MM/yyyy', 'en'))
  }


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
      this.vehicleAvailabilityService.getAvailability(this.vehicleAvailability).subscribe(data => {
        console.log(data)

        if (data.availability) {
          this.price = data.price;
        }else {
          this.notificationService.showError("No riders are currently available", "Booking Unavailable")
        }

      }, error => {
        console.log(error)
      })
    }


  }
}
