import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityChargeComponent } from './city-charge.component';

describe('CityChargeComponent', () => {
  let component: CityChargeComponent;
  let fixture: ComponentFixture<CityChargeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CityChargeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CityChargeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
