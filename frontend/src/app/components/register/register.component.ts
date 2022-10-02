import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer-model/customer";
import {CustomerService} from "../../service/customer-service/customer.service";
import {NotificationService} from "../../service/notification-service/notification.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {NgxSpinnerService} from "ngx-spinner";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  customer: Customer = new Customer();

  registerForm?: FormGroup;

  constructor(private customerService: CustomerService,
              private notifyService: NotificationService,
              private spinnerService: NgxSpinnerService) {

  }

  ngOnInit(): void {
    this.createForm()
  }


  createForm() {
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

    if (this.customer.fname == null || this.customer.fname.length == 0) {
      this.notifyService.showWarning("First name not be empty", "Required Feild Missing")
    } else if (this.customer.lname == null || this.customer.lname.length == 0) {
      this.notifyService.showWarning("Last name not be empty", "Required Feild Missing")
    } else if (this.customer.mobile == null || this.customer.mobile.length == 0) {
      this.notifyService.showWarning("Mobile number not be empty", "Required Feild Missing")
    } else if (this.customer.email == null || this.customer.email.length == 0) {
      this.notifyService.showWarning("Email not be empty", "Required Feild Missing")
    } else if (this.customer.password == null || this.customer.password.length < 6) {
      this.notifyService.showWarning("Password should be minimum 6 characters", "Required Feild Missing")
    } else if (this.customer.password != this.customer.confirm_password) {
      this.notifyService.showWarning("Confirm Password not same", "Required Feild Missing")
    } else {

      this.spinnerService.show();

      this.customerService.saveCustomer(this.customer)
        .subscribe(data => {
            this.customer = new Customer();
            this.spinnerService.hide();
            this.notifyService.showSuccess("Registration Success, Please Login", "Success");
          },
          error => {
            this.spinnerService.hide();
            this.notifyService.showError("Something Went Wrong, Please try again", "Error")
          })
    }
  }

}
