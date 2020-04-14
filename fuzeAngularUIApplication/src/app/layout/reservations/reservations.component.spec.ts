import { async, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { ReservationsComponent } from './reservations.component';
import { ReservationsModule } from './reservations.module';

describe('ReservationsModule', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ ReservationsModule, RouterTestingModule ],
    })
    .compileComponents();
  }));

  it('should create', () => {
    const fixture = TestBed.createComponent(ReservationsModule);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});
