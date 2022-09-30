import { Component, OnInit } from '@angular/core';
import {Customer} from "../../model/customer-model/customer";
import {CustomerService} from "../../service/customer-service/customer.service";
import {NotificationService} from "../../service/notification-service/notification.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customer: Customer = new Customer();

  registerForm?: FormGroup;

  constructor(private customerService: CustomerService,
              private notifyService: NotificationService){

  }

  ngOnInit(): void {
    this.createForm()
  }


  createForm(){
    this.registerForm = new FormGroup({
      fname: new FormControl(this.customer.fname, [
        Validators.required,
      ]),
      lname: new FormControl(this.customer.lname, [
        Validators.required,
      ]),
      mobile: new FormControl(this.customer.mobile, [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(12)
      ]),
      email: new FormControl(this.customer.email, [
        Validators.required,
        Validators.email,
      ]),
      password: new FormControl(this.customer.password, [
        Validators.required,
        Validators.minLength(6),
      ]),
      confirm_password: new FormControl(this.customer.confirm_password, [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }


  saveCustomer() {
    this.customerService.saveCustomer(this.customer)
      .subscribe(data => {
        this.customer = new Customer();
        this.notifyService.showSuccess("Registration Success", "Success");
      })
  }

}
