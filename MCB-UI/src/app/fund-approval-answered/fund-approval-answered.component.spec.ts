import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FundApprovalAnsweredComponent } from './fund-approval-answered.component';

describe('FundApprovalAnsweredComponent', () => {
  let component: FundApprovalAnsweredComponent;
  let fixture: ComponentFixture<FundApprovalAnsweredComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FundApprovalAnsweredComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FundApprovalAnsweredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
