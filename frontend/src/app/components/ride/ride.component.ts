import {Component, OnInit} from '@angular/core';
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {VehicleAvailabilityService} from "../../service/vehicle-availability-service/vehicle-availability.service";
import {VehicleAvailability} from "../../model/vehicle-availability-model/vehicle-availability";

@Component({
  selector: 'app-ride',
  templateUrl: './ride.component.html',
  styleUrls: ['./ride.component.css']
})
export class RideComponent implements OnInit {

  cities?: City[];
  vehicleCategories?: VehicleCategory[];
  vehicleAvailability: VehicleAvailability = new VehicleAvailability();

  constructor(private cityService: CityService,
              private vehicleCategoryService: VehicleCategoryService,
              private vehicleAvailabilityService: VehicleAvailabilityService) {
  }

  ngOnInit(): void {
    this.getCities()
    this.getVehicleCategories()
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
        console.log()

      }, error => {
        console.log(error)
      })
    }


  }
}
