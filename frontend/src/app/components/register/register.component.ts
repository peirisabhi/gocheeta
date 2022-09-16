import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer-model/customer";
import {CustomerService} from "../../service/customer-service/customer.service";
import {NotificationService} from "../../service/notification-service/notification.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customer: Customer = new Customer();

  constructor(private customerService: CustomerService,
              private notifyService: NotificationService){

  }

  ngOnInit(): void {
  }

  saveCustomer() {
    this.customerService.saveCustomer(this.customer)
      .subscribe(data => {
        this.customer = new Customer();
        this.notifyService.showSuccess("Registration Success", "Success");
      })
  }

}
