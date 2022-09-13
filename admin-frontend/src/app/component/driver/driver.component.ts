import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient, HttpEventType, HttpResponse} from "@angular/common/http";
import {environment} from "../../../environments/environment";
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

  selectNICFront(event: any): void {
    this.driver.nicFront = (event.target.files).item(0);
  }

  selectNICBack(event: any): void {
    this.driver.nicBack = (event.target.files).item(0);
  }

  selectDrivingLicenceFront(event: any): void {
    this.driver.drivingLicenceFront = (event.target.files).item(0);
  }

  selectDrivingLicenceBack(event: any): void {
    this.driver.drivingLicenceBack = (event.target.files).item(0);
  }

  getLicenceTypes() {
    this.licenceTypeService.getLicenceTypes().subscribe(data => {
      this.licenceTypes = data;
    }, error => {
      console.log(error)
    })
  }



  saveDriver(): void {
    const formData: FormData = new FormData();
    Object.entries(this.driver).forEach(
      ([key, value]) => formData.append(key, value)
    );

    this.driverService.saveDriver(formData).subscribe({
      next: (event: any) => {
        // if (event.type === HttpEventType.UploadProgress) {
        //   this.progress = Math.round(100 * event.loaded / event.total);
        // } else if (event instanceof HttpResponse) {
        //   this.message = event.body.message;
        //   // this.fileInfos = this.testService.getFiles();
        // }
        console.log("success")
      },
      error: (err: any) => {
        console.log(err);
        // this.progress = 0;
        // if (err.error && err.error.message) {
        //   this.message = err.error.message;
        // } else {
        //   this.message = 'Could not upload the file!';
        // }
        // this.currentFile = undefined;
      }
    });
  }

}
