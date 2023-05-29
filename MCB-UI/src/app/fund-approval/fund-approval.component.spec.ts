import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FundApprovalComponent } from './fund-approval.component';

describe('FundApprovalComponent', () => {
  let component: FundApprovalComponent;
  let fixture: ComponentFixture<FundApprovalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FundApprovalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FundApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
