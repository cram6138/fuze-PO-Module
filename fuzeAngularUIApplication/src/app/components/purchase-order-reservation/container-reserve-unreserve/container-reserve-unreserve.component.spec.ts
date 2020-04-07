import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerReserveUnreserveComponent } from './container-reserve-unreserve.component';

describe('ContainerReserveUnreserveComponent', () => {
  let component: ContainerReserveUnreserveComponent;
  let fixture: ComponentFixture<ContainerReserveUnreserveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContainerReserveUnreserveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContainerReserveUnreserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
