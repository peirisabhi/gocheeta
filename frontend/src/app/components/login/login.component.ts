import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth-service/auth.service";
import {StorageService} from "../../service/storage-service/storage.service";
import {Router} from "@angular/router";
import {NotificationService} from "../../service/notification-service/notification.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form: any = {
    username: null,
    password: null
  };

  constructor(private authService: AuthService,
              private storageService: StorageService,
              private router: Router,
              private notifyService: NotificationService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.login(username, password).subscribe({
      next: data => {
        this.storageService.saveUser(data);
        //
        // this.isLoginFailed = false;
        // this.isLoggedIn = true;
        // this.roles = this.storageService.getUser().roles;
        console.log("success - ", data)
        console.log("storage -- " , this.storageService.getUser())
        this.reloadPage()
      },
      error: err => {
        // this.errorMessage = err.error.message;
        // this.isLoginFailed = true;
        console.log("error -- ", err)
        this.notifyService.showError("Login Failed", "Error")
      }
    });
  }

  reloadPage(): void {
    window.location.replace('/');
  }
}
