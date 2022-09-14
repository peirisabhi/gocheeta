import {Component, OnInit} from '@angular/core';
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {Vehicle} from "../../model/vehicle-model/vehicle";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient} from "@angular/common/http";
import {VehicleService} from "../../service/vehicle-service/vehicle.service";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {DriverService} from "../../service/driver-service/driver.service";
import {Driver} from "../../model/driver-model/driver";
import {DataTablesResponse} from "../../model/data-tables-response-model/data-tables-response";
import {environment} from "../../../environments/environment";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  vehicle: Vehicle = new Vehicle();
  dtOptions: DataTables.Settings = {};
  vehicleCategories?: VehicleCategory[];
  drivers?: Driver[];
  vehicles?: Vehicle[];

  constructor(private modalService: NgbModal,
              private notifyService: NotificationService,
              private http: HttpClient,
              private vehicleService: VehicleService,
              private vehicleCategoryService: VehicleCategoryService,
              private driverService: DriverService) {
  }

  ngOnInit(): void {
    this.getVehicleCategories()
    this.getDrivers()
    this.loadDataTable()
  }

  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }

  getVehicleCategories() {
    this.vehicleCategoryService.getVehicleCategories().subscribe(data => {
      this.vehicleCategories = data;
    }, error => {
      console.log(error)
    })
  }

  getDrivers() {
    this.driverService.getDrivers().subscribe(data => {
      this.drivers = data;
    }, error => {
      console.log(error)
    })
  }

  saveVehicle() {
    this.vehicleService.saveVehicle(this.vehicle)
      .subscribe(data => {
        this.vehicle = new Vehicle();
        this.notifyService.showSuccess("Successfully Vehicle Saved", "Success");
      })
  }


  loadDataTable() {
    this.dtOptions = {
      serverSide: true,
      processing: true,
      ajax: (dataTablesParameters: any, callback) => {
        this.http
          .post<DataTablesResponse>(
            apiURL + 'vehicle/data',
            dataTablesParameters, {}
          ).subscribe(resp => {
          this.vehicles = resp.data;

          callback({
            recordsTotal: resp.recordsTotal,
            recordsFiltered: resp.recordsFiltered,
            data: []
          });
        });
      },
      columns: [
        {data: 'id'},
        {data: 'city_from'},
        {data: 'city_to'},
        {data: 'km'},
      ]
    };
  }

}
