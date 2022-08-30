import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {City} from "../../model/city-model/city";
import {CityService} from "../../service/city-service/city.service";
import {NotificationService} from "../../service/notification-service/notification.service";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {DataTablesResponse} from "../../model/data-tables-response-model/data-tables-response";

let apiURL = environment.apiURL;

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {

  city: City = new City();
  dtOptions: DataTables.Settings = {};
  cities?: any[];

  constructor(private modalService: NgbModal,
              private cityService: CityService,
              private notifyService: NotificationService,
              private http: HttpClient) {

  }

  ngOnInit(): void {
    this.loadDataTable();
  }


  open(content: any) {
    console.log(content)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'});
  }

  close(content: any) {
    this.modalService.dismissAll();
  }

  saveCity() {
    this.cityService.saveCity(this.city)
      .subscribe(data => {
        this.city = new City();
        this.notifyService.showSuccess("Successfully City Saved", "Success");
      })
  }

  loadDataTable() {
    this.dtOptions = {
      serverSide: true,
      processing: true,
      ajax: (dataTablesParameters: any, callback) => {
        this.http
          .post<DataTablesResponse>(
            apiURL + 'city1/data',
            dataTablesParameters, {}
          ).subscribe(resp => {
          this.cities = resp.data;

          callback({
            recordsTotal: resp.recordsTotal,
            recordsFiltered: resp.recordsFiltered,
            data: []
          });
        });
      },
      columns: [
        {data: 'id'},
        {data: 'city'}
      ]
    };
  }
}
