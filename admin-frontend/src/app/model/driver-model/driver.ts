export class Driver {
  id?: number;
  fname?: string;
  lname?: string;
  email?: string;
  gender?: string = "0";
  nic?: string;
  dob?: string;
  contact1?: string;
  contact2?: string;
  licenceTypeId?: string = "0";
  licenceType?: string;
  nicFront?: File;
  nicBack?: File;
  drivingLicenceFront?: File;
  drivingLicenceBack?: File;
  registeredAt?: string;
  registeredBy?: string;


}
