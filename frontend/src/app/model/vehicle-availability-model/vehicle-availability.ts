export class VehicleAvailability {
  vehicle_category: number = 0;
  from_city: number = 0;
  to_city: number = 0;
  price?: string;
  availability?: boolean;
  date ?: string;
  time?: string;


  constructor() {
    let isoString = new Date().toISOString();
    console.log("isoString", isoString)
    this.date = isoString.split('T')[0];
    this.time = isoString.split('T')[1].split('.')[0];
  }
}
