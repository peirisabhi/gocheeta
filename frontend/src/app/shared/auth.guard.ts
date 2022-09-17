import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from "../service/auth-service/auth.service";
import {StorageService} from "../service/storage-service/storage.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(public storageService: StorageService, public router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.storageService.isLoggedIn() !== true) {
      window.alert('Access Denied, Login is Required to Access This Page!');
      this.router.navigate(['login']);
    }

    // if (this.jwtService.getUser()) {
    //   if (this.jwtService.isTokenExpired()) {
    //     // Should Redirect Sig-In Page
    //   } else {
    //     return true;
    //   }
    // } else {
    //   return new Promise((resolve) => {
    //     this.loginService.signIncallBack().then((e) => {
    //       resolve(true);
    //     }).catch((e) => {
    //       // Should Redirect Sign-In Page
    //     });
    //   });
    // }

    return true;
  }

}
