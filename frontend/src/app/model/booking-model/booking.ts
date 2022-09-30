import {formatDate} from "@angular/common";

export class Booking {
  id?: string;
  date?: string;
  time?: string;
  vehicle_category: number = 0;
  from_city: number = 0;
  to_city: number = 0;
  pick_up_street?: string;
  drop_off_street?: string;
  special_note?: string;
  driver?: string;
  vehicle_category_val?: string;
  price?: string;
  status?: string;
  from_city_val?: string;
  to_city_val?: string;
}
