import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseOrderReservationComponent } from './purchase-order-reservation.component';

describe('PurchaseOrderReservationComponent', () => {
  let component: PurchaseOrderReservationComponent;
  let fixture: ComponentFixture<PurchaseOrderReservationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseOrderReservationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseOrderReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
