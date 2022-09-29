import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RideComponent} from "./components/ride/ride.component";
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {DriveComponent} from "./components/drive/drive.component";
import {AuthGuard} from "./shared/auth.guard";
import {PreviousTripsComponent} from "./components/previous-trips/previous-trips.component";
import {BookingSuccessComponent} from "./components/booking-success/booking-success.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'ride', component: RideComponent, canActivate: [AuthGuard]},
  {path: 'drive', component: DriveComponent},
  {path: 'previous-trips', component: PreviousTripsComponent},
  {path: 'booking-success', component: BookingSuccessComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
