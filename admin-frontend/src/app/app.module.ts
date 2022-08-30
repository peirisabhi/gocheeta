import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { TopbarComponent } from './component/common/topbar/topbar.component';
import { SideNavbarComponent } from './component/common/side-navbar/side-navbar.component';
import { UserComponent } from './component/user/user.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { ToastrModule } from 'ngx-toastr';
import {DataTablesModule} from "angular-datatables";
import { CityComponent } from './component/city/city.component';
import { DistanceChargeComponent } from './component/distance-charge/distance-charge.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    TopbarComponent,
    SideNavbarComponent,
    UserComponent,
    CityComponent,
    DistanceChargeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    DataTablesModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
