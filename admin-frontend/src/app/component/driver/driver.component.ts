import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient, HttpEventType, HttpResponse} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Driver} from "../../model/driver-model/driver";
import {DriverService} from "../../service/driver-service/driver.service";
import {LicenceTypeService} from "../../service/licence-type-service/licence-type.service";
import {LicenceType} from "../../model/licence-type-model/licence-type";
import {DataTablesResponse} from "../../model/data-tables-response-model/data-tables-response";
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {

  driver: Driver = new Driver();
  licenceTypes?: LicenceType[];
  cities?: City[];
  dtOptions: DataTables.Settings = {};
  drivers ?: any[];

  constructor(private modalService: NgbModal,
              private notifyService: NotificationService,
              private http: HttpClient,
              private driverService: DriverService,
              private licenceTypeService: LicenceTypeService,
              private cityService: CityService) {

  }

  ngOnInit(): void {
    this.getLicenceTypes();
    this.getCities();
    this.loadDataTable();
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

  getCities() {
    this.cityService.getCities().subscribe(data => {
      this.cities = data;
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
        if (event.type === HttpEventType.UploadProgress) {
          // this.progress = Math.round(100 * event.loaded / event.total);
          console.log(Math.round(100 * event.loaded / event.total))
        } else if (event instanceof HttpResponse) {
          console.log("message- ", event.body.message)
          // this.message = event.body.message;
          // this.fileInfos = this.testService.getFiles();
        }


      },
      error: (err: any) => {
        console.log(err);
        this.notifyService.showError("Something Went Wrong", "Error")

      },
      complete: () => {
        console.log("success")
        this.driver = new Driver();
        this.notifyService.showSuccess("Driver Saved Successfully", "Success")
      },

    });
  }


  loadDataTable() {
    this.dtOptions = {
      serverSide: true,
      processing: true,
      ajax: (dataTablesParameters: any, callback) => {
        this.http
          .post<DataTablesResponse>(
            apiURL + 'driver/data',
            dataTablesParameters, {}
          ).subscribe(resp => {
          this.drivers = resp.data;

          callback({
            recordsTotal: resp.recordsTotal,
            recordsFiltered: resp.recordsFiltered,
            data: []
          });
        });
      },
      columns: [
        {data: 'id'},
        {data: 'fname'},
        {data: 'lname'},
      ]
    };
  }

}
