import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavComponent} from './components/common/nav/nav.component';
import {FooterComponent} from './components/common/footer/footer.component';
import {HomeComponent} from "./components/home/home.component";
import {RideComponent} from './components/ride/ride.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {DriveComponent} from './components/drive/drive.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";
import {AuthService} from "./service/auth-service/auth.service";
import {AuthGuard} from "./shared/auth.guard";
import {RequestInterceptor} from "./helpers/request.interceptor";
import { PreviousTripsComponent } from './components/previous-trips/previous-trips.component';
import { SideNavComponent } from './components/common/side-nav/side-nav.component';
import {NgxSpinnerModule} from "ngx-spinner";
import { BookingSuccessComponent } from './components/booking-success/booking-success.component';
import { ProfileSettingsComponent } from './components/profile-settings/profile-settings.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HomeComponent,
    RideComponent,
    LoginComponent,
    RegisterComponent,
    DriveComponent,
    PreviousTripsComponent,
    SideNavComponent,
    BookingSuccessComponent,
    ProfileSettingsComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgxSpinnerModule,
    // ReactiveFormsModule
  ],
  providers: [
    AuthService,
    AuthGuard,
    {provide: HTTP_INTERCEPTORS, useClass: RequestInterceptor, multi: true},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
