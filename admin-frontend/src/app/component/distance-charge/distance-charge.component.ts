import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {DistanceCharge} from "../../model/distance-charge-model/distance-charge";
import {DistanceChargeService} from "../../service/distance-charge-service/distance-charge.service";
import {City} from "../../model/city-model/city";
import {NotificationService} from "../../service/notification-service/notification.service";

@Component({
  selector: 'app-distance-charge',
  templateUrl: './distance-charge.component.html',
  styleUrls: ['./distance-charge.component.css']
})
export class DistanceChargeComponent implements OnInit {

  distanceCharge: DistanceCharge = new DistanceCharge();

  constructor(private modalService: NgbModal,
              private distanceChargeService: DistanceChargeService,
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

  saveDistanceCharge() {
    this.distanceChargeService.saveDistanceCharge(this.distanceCharge)
      .subscribe(data => {
        this.distanceCharge = new DistanceCharge();
        this.notifyService.showSuccess("Successfully Distance Charge Saved", "Success");
      })
  }
}
