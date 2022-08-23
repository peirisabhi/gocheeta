import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/common/nav/nav.component';
import { FooterComponent } from './components/common/footer/footer.component';
import {HomeComponent} from "./components/home/home.component";
import { RideComponent } from './components/ride/ride.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { DriveComponent } from './components/drive/drive.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HomeComponent,
    RideComponent,
    LoginComponent,
    RegisterComponent,
    DriveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
