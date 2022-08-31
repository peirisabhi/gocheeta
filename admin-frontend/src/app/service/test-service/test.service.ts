import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";


let apiURL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class TestService {

  constructor(private http: HttpClient) {

  }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    formData.append('name', 'test name')
    const req = new HttpRequest('POST', apiURL+"test", formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }
  // getFiles(): Observable<any> {
  //   return this.http.get(`${this.apiURL}/files`);
  // }
}
