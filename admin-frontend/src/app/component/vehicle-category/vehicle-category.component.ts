import {Component, OnInit} from '@angular/core';
import {environment} from "../../../environments/environment";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";
import {City} from "../../model/city-model/city";
import {NotificationService} from "../../service/notification-service/notification.service";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-vehicle-category',
  templateUrl: './vehicle-category.component.html',
  styleUrls: ['./vehicle-category.component.css']
})
export class VehicleCategoryComponent implements OnInit {

  vehicleCategory: VehicleCategory = new VehicleCategory();

  constructor(private modalService: NgbModal,
              private vehicleCategoryService: VehicleCategoryService,
              private notifyService: NotificationService,) {

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


  saveVehicleCategory() {
    this.vehicleCategoryService.saveVehicleCategory(this.vehicleCategory)
      .subscribe(data => {
        this.vehicleCategory = new VehicleCategory();
        this.notifyService.showSuccess("Successfully Category Saved", "Success");
      })
  }

}
