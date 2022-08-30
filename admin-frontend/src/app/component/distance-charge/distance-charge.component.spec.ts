import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistanceChargeComponent } from './distance-charge.component';

describe('DistanceChargeComponent', () => {
  let component: DistanceChargeComponent;
  let fixture: ComponentFixture<DistanceChargeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistanceChargeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DistanceChargeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
