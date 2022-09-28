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
    // console.log("isoString", new Date().toLocaleTimeString())
    // console.log("isoString", new Date().toLocaleDateString())
    let date = new Date();
    this.date = isoString.split('T')[0];
    // this.time = isoString.split('T')[1].split('.')[0];
    this.time = date.toTimeString().split(' ')[0].substring(0, 5);

    // console.log(this.date)
    // console.log(this.time)
    // console.log(date.toLocaleTimeString().split(' ')[0])
    // console.log(date.toTimeString().split(' ')[0].substring(0, 5))
    // console.log(date.toLocaleDateString())

  }
}
