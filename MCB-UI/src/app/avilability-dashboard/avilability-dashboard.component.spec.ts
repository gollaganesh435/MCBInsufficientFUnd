import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvilabilityDashboardComponent } from './avilability-dashboard.component';

describe('AvilabilityDashboardComponent', () => {
  let component: AvilabilityDashboardComponent;
  let fixture: ComponentFixture<AvilabilityDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvilabilityDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvilabilityDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
