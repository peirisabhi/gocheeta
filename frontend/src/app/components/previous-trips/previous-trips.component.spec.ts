import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreviousTripsComponent } from './previous-trips.component';

describe('PreviousTripsComponent', () => {
  let component: PreviousTripsComponent;
  let fixture: ComponentFixture<PreviousTripsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreviousTripsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreviousTripsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
