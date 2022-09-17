import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";


let apiURL = environment.apiURL;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : '*'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient : HttpClient) { }


  login(username: string, password: string): Observable<any> {
    return this.httpClient.post(
      apiURL + 'customer/login',
      {
        username,
        password,
      },
      httpOptions
    );
  }
}
