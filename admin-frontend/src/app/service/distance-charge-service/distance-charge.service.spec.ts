import { TestBed } from '@angular/core/testing';

import { DistanceChargeService } from './distance-charge.service';

describe('DistanceChargeService', () => {
  let service: DistanceChargeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DistanceChargeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
