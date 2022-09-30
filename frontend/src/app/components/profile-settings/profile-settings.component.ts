import { Component, OnInit } from '@angular/core';
import {StorageService} from "../../service/storage-service/storage.service";
import {Customer} from "../../model/customer-model/customer";

@Component({
  selector: 'app-profile-settings',
  templateUrl: './profile-settings.component.html',
  styleUrls: ['./profile-settings.component.css']
})
export class ProfileSettingsComponent implements OnInit {

  customer: Customer = new Customer();

  constructor(private storageService: StorageService) {
    this.customer.id = this.storageService.getUser().data.id;
    this.customer.fname = this.storageService.getUser().data.fname;
    this.customer.lname = this.storageService.getUser().data.lname;
    this.customer.dob = this.storageService.getUser().data.dob;
    this.customer.gender = this.storageService.getUser().data.gender;
    this.customer.email = this.storageService.getUser().data.email;
    this.customer.mobile = this.storageService.getUser().data.mobile;
    this.customer.nic = this.storageService.getUser().data.nic;

    console.log(this.customer)
  }

  ngOnInit(): void {

  }

}
