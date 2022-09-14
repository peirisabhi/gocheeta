import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {UserComponent} from "./component/user/user.component";
import {CityComponent} from "./component/city/city.component";
import {DistanceChargeComponent} from "./component/distance-charge/distance-charge.component";
import {VehicleCategoryComponent} from "./component/vehicle-category/vehicle-category.component";
import {DriverComponent} from "./component/driver/driver.component";
import {TestComponent} from "./component/test/test.component";
import {CityChargeComponent} from "./component/city-charge/city-charge.component";
import {VehicleComponent} from "./component/vehicle/vehicle.component";

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'dashboard', component:DashboardComponent},
  {path: 'user', component:UserComponent},
  {path: 'city', component:CityComponent},
  {path: 'distance-charge', component:DistanceChargeComponent},
  {path: 'vehicle-model-category', component:VehicleCategoryComponent},
  {path: 'driver', component:DriverComponent},
  {path: 'test', component:TestComponent},
  {path: 'city-charge', component:CityChargeComponent},
  {path: 'vehicle', component:VehicleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
