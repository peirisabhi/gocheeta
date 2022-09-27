import {formatDate} from "@angular/common";

export class Booking {
  date?: string;
  time?: string;
  vehicle_category: number = 0;
  from_city: number = 0;
  to_city: number = 0;
  pick_up_street?: string;
  drop_off_street?: string;
  special_note?: string;
}
