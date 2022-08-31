import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {City} from "../../model/city-model/city";
import {Driver} from "../../model/driver-model/driver";
import {DriverService} from "../../service/driver-service/driver.service";
import {LicenceTypeService} from "../../service/licence-type-service/licence-type.service";
import {LicenceType} from "../../model/licence-type-model/licence-type";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {

  driver: Driver = new Driver();
  licenceTypes?: LicenceType[];
  // file?: File;

  constructor(private modalService: NgbModal,
              private notifyService: NotificationService,
              private http: HttpClient,
              private driverService: DriverService,
              private licenceTypeService: LicenceTypeService) {

  }

  ngOnInit(): void {
    this.getLicenceTypes();
  }


  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }

  getLicenceTypes() {
    this.licenceTypeService.getLicenceTypes().subscribe(data => {
      this.licenceTypes = data;
    }, error => {
      console.log(error)
    })
  }

  saveDriver() {

    // this.driverService.saveDriver(this.driver)
    //   .subscribe(data => {
    //     this.driver = new Driver();
    //     this.notifyService.showSuccess("Successfully Driver Saved", "Success");
    //   })


    let formData = new FormData();
    Object.entries(this.driver).forEach(
      ([key, value]) => formData.append(key, value)
    );

    // @ts-ignore
    // formData.append("nic_front", this.file);

    console.log("Form data  --  " + formData)

    this.http.post<any>(apiURL + "driver", formData,
      {
        headers: {

        }
      }).subscribe(data => {
      console.log(data)
    })
  }

}
