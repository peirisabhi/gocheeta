import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {DistanceCharge} from "../../model/distance-charge-model/distance-charge";
import {DistanceChargeService} from "../../service/distance-charge-service/distance-charge.service";
import {City} from "../../model/city-model/city";
import {NotificationService} from "../../service/notification-service/notification.service";
import {DataTablesResponse} from "../../model/data-tables-response-model/data-tables-response";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-distance-charge',
  templateUrl: './distance-charge.component.html',
  styleUrls: ['./distance-charge.component.css']
})
export class DistanceChargeComponent implements OnInit {

  distanceCharge: DistanceCharge = new DistanceCharge();
  dtOptions: DataTables.Settings = {};
  distanceCharges ?: any[];

  vehicleCategories?: VehicleCategory[];

  constructor(private modalService: NgbModal,
              private distanceChargeService: DistanceChargeService,
              private vehicleCategoryService: VehicleCategoryService,
              private notifyService: NotificationService,
              private http: HttpClient) {

  }

  ngOnInit(): void {
    this.loadDataTable();
    this.getVehicleCategories();
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

  saveDistanceCharge() {
    this.distanceChargeService.saveDistanceCharge(this.distanceCharge)
      .subscribe(data => {
        this.distanceCharge = new DistanceCharge();
        this.notifyService.showSuccess("Successfully Distance Charge Saved", "Success");
      })
  }


  loadDataTable() {
    this.dtOptions = {
      serverSide: true,
      processing: true,
      ajax: (dataTablesParameters: any, callback) => {
        this.http
          .post<DataTablesResponse>(
            apiURL + 'distance-charge/data',
            dataTablesParameters, {}
          ).subscribe(resp => {
          this.distanceCharges = resp.data;

          callback({
            recordsTotal: resp.recordsTotal,
            recordsFiltered: resp.recordsFiltered,
            data: []
          });
        });
      },
      columns: [
        {data: 'id'},
        {data: 'km_from'},
        {data: 'km_to'},
        {data: 'price'},
        {data: 'last_update'},
      ]
    };
  }
}
