import { TestBed } from '@angular/core/testing';

import { CityChargeService } from './city-charge.service';

describe('CityChargeService', () => {
  let service: CityChargeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CityChargeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
