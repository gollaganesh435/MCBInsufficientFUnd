import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FundAvailabilityListComponent } from './fund-availability-list.component';

describe('FundAvailabilityListComponent', () => {
  let component: FundAvailabilityListComponent;
  let fixture: ComponentFixture<FundAvailabilityListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FundAvailabilityListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FundAvailabilityListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
