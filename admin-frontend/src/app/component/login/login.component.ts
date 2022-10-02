import { Component, OnInit } from '@angular/core';
import {StorageService} from "../../service/storage-service/storage.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private storageService: StorageService,) { }

  ngOnInit(): void {
  }

  form: any = {
    username: null,
    password: null
  };

  goToDashboard(){

    const { username, password } = this.form;

    // if ()

    window.location.replace('/dashboard')
  }

  onSubmit(): void {
    const { username, password } = this.form;

    console.log(username)

    if (username == "admin@gmail.com"){
      this.storageService.set("role", "admin");
    }else{
      this.storageService.set("role", "user");
    }
    window.location.replace('/dashboard')
  }

}
