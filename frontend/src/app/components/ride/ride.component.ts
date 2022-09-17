import { Component, OnInit } from '@angular/core';
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";

@Component({
  selector: 'app-ride',
  templateUrl: './ride.component.html',
  styleUrls: ['./ride.component.css']
})
export class RideComponent implements OnInit {

  cities?: City[];


  constructor(private cityService: CityService) { }

  ngOnInit(): void {
    this.getCities()
  }


  getCities() {
    this.cityService.getCities().subscribe(data => {
      this.cities = data;
    }, error => {
      console.log(error)
    })
  }
}
