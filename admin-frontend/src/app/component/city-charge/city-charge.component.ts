import { Component, OnInit } from '@angular/core';
import {environment} from "../../../environments/environment";
import {CityCharge} from "../../model/city-charge-model/city-charge";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient} from "@angular/common/http";
import {CityChargeService} from "../../service/city-charge-service/city-charge.service";
import {DistanceCharge} from "../../model/distance-charge-model/distance-charge";
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-city-charge',
  templateUrl: './city-charge.component.html',
  styleUrls: ['./city-charge.component.css']
})
export class CityChargeComponent implements OnInit {

  cityCharge : CityCharge = new CityCharge();
  dtOptions: DataTables.Settings = {};
  cityCharges ?: any[];
  cities?: City[];

  constructor(private modalService: NgbModal,
              private notifyService: NotificationService,
              private http: HttpClient,
              private cityChargeService: CityChargeService,
              private cityService: CityService) { }

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

  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }


  saveCityCharge() {
    this.cityChargeService.saveCityCharge(this.cityCharge)
      .subscribe(data => {
        this.cityCharge = new CityCharge();
        this.notifyService.showSuccess("Successfully City Charge Saved", "Success");
      })
  }

}
