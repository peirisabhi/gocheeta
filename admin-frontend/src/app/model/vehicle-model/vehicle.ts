export class Vehicle {
  id?: number;
  vehicle_category_id: number = 0;
  vehicle_category?: string;
  vehicle_make?: string;
  vehicle_model?: string;
  vehicle_number?: string;
  mac_passengers?: number;
  registered_at?: string;
  registered_by?: string;
  driver_id: number = 0;
  driver?: string;
  city_id?: number;
  city?: string;
}
