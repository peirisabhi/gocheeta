import {formatDate} from "@angular/common";

export class Booking {
  date = formatDate(new Date(), 'dd/MM/yyyy', 'en');
  time = new Date();
  vehicle_category: number = 0;
  from_city: number = 0;
  to_city: number = 0;
}
