import { Component, OnInit } from '@angular/core';
import {StorageService} from "../../../service/storage-service/storage.service";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  isLoggedIn = false;
  loggedUsersName = "";
  loggedUsersImg = "";

  constructor(private storageService: StorageService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.loggedUsersName = this.storageService.getUser().data.fname;
    }


  }



}
