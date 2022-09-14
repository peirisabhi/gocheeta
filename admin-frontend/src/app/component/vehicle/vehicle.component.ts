import {Component, OnInit} from '@angular/core';
import {VehicleCategory} from "../../model/vehicle-category-model/vehicle-category";
import {Vehicle} from "../../model/vehicle-model/vehicle";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {NotificationService} from "../../service/notification-service/notification.service";
import {HttpClient} from "@angular/common/http";
import {VehicleService} from "../../service/vehicle-service/vehicle.service";
import {VehicleCategoryService} from "../../service/vehicle-category-service/vehicle-category.service";

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {

  vehicle: Vehicle = new Vehicle();
  dtOptions: DataTables.Settings = {};
  vehicleCategories?: VehicleCategory[];

  constructor(private modalService: NgbModal,
              private notifyService: NotificationService,
              private http: HttpClient,
              private vehicleService: VehicleService,
              private vehicleCategoryService: VehicleCategoryService) {
  }

  ngOnInit(): void {
    this.getVehicleCategories()
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

  saveVehicle() {
    this.vehicleService.saveVehicle(this.vehicle)
      .subscribe(data => {
        this.vehicle = new Vehicle();
        this.notifyService.showSuccess("Successfully Vehicle Saved", "Success");
      })
  }


}
