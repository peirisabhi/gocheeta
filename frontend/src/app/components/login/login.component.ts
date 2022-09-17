import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth-service/auth.service";

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

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username, password } = this.form;
    
    this.authService.login(username, password).subscribe({
      next: data => {
        // this.storageService.saveUser(data);
        //
        // this.isLoginFailed = false;
        // this.isLoggedIn = true;
        // this.roles = this.storageService.getUser().roles;
        // this.reloadPage();
        console.log("success - ", data)
      },
      error: err => {
        // this.errorMessage = err.error.message;
        // this.isLoginFailed = true;
        console.log("error -- ", err)
      }
    });
  }

}
