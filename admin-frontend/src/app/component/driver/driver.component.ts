import { Component, OnInit } from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {City} from "../../model/city-model/city";
import {Driver} from "../../model/driver-model/driver";
import {DriverService} from "../../service/driver-service/driver.service";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {

  driver : Driver = new Driver();

  constructor(private modalService: NgbModal,
              private notifyService: NotificationService,
              private http: HttpClient,
              private driverService: DriverService) {

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

  saveDriver() {
    this.driverService.saveDriver(this.driver)
      .subscribe(data => {
        this.driver = new Driver();
        this.notifyService.showSuccess("Successfully Driver Saved", "Success");
      })
  }

}
