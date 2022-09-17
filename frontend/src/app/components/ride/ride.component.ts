import {Component, OnInit} from '@angular/core';
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";

@Component({
  selector: 'app-ride',
  templateUrl: './ride.component.html',
  styleUrls: ['./ride.component.css']
})
export class RideComponent implements OnInit {

  cities?: City[];
  vehicleCategories?: VehicleCategory[];

  constructor(private cityService: CityService,
              private vehicleCategoryService: VehicleCategoryService) {
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
}
