import { Component, OnInit } from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {User} from "../../../model/user-model/user";
import {City} from "../../../model/city-model/city";
import {CityService} from "../../../service/city-service/city.service";
import {NotificationService} from "../../../service/notification-service/notification.service";

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  city : City = new City();

  constructor(private modalService: NgbModal,
              private cityService : CityService,
              private notifyService: NotificationService) {

  }

  ngOnInit(): void {
  }


  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }

  saveCity() {
    this.cityService.saveCity(this.city)
      .subscribe(data => {
        this.city = new City();
        this.notifyService.showSuccess("Successfully City Saved", "Success");
      })
  }
}
