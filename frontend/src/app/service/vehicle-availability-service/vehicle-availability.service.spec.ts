import { TestBed } from '@angular/core/testing';

import { VehicleAvailabilityService } from './vehicle-availability.service';

describe('VehicleAvailabilityService', () => {
  let service: VehicleAvailabilityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehicleAvailabilityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
