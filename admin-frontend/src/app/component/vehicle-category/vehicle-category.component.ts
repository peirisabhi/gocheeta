import {Component, OnInit} from '@angular/core';
import {environment} from "../../../environments/environment";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {City} from "../../model/city-model/city";
import {NotificationService} from "../../service/notification-service/notification.service";
import {DataTablesResponse} from "../../model/data-tables-response-model/data-tables-response";
import {HttpClient} from "@angular/common/http";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-vehicle-category',
  templateUrl: './vehicle-category.component.html',
  styleUrls: ['./vehicle-category.component.css']
})
export class VehicleCategoryComponent implements OnInit {

  vehicleCategory: VehicleCategory = new VehicleCategory();
  dtOptions: DataTables.Settings = {};
  vehicleCategories ?: any[];

  constructor(private modalService: NgbModal,
              private vehicleCategoryService: VehicleCategoryService,
              private notifyService: NotificationService,
              private http: HttpClient) {

  }

  ngOnInit(): void {
    this.loadDataTable()
  }

  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }


  saveVehicleCategory() {
    this.vehicleCategoryService.saveVehicleCategory(this.vehicleCategory)
      .subscribe(data => {
        this.vehicleCategory = new VehicleCategory();
        this.notifyService.showSuccess("Successfully Category Saved", "Success");
      })
  }

  loadDataTable() {
    this.dtOptions = {
      serverSide: true,
      processing: true,
      ajax: (dataTablesParameters: any, callback) => {
        this.http
          .post<DataTablesResponse>(
            apiURL + 'vehicle-model-category/data',
            dataTablesParameters, {}
          ).subscribe(resp => {
          this.vehicleCategories = resp.data;

          callback({
            recordsTotal: resp.recordsTotal,
            recordsFiltered: resp.recordsFiltered,
            data: []
          });
        });
      },
      columns: [
        {data: 'id'},
        {data: 'city'}
      ]
    };
  }

}
