import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {UserRole} from "../../model/user-role-model/user-role";

let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class UserRoleService {


  constructor(private httpClient : HttpClient) { }

  getUserRoles(): Observable<UserRole[]>{
    console.log(apiURL + 'user-role');
    return this.httpClient.get<UserRole[]>(apiURL + 'user-role');
  }
}
