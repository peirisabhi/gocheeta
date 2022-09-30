import { Component, OnInit } from '@angular/core';
import {StorageService} from "../../../service/storage-service/storage.service";

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {

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
