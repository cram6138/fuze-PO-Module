import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerSearchReserveComponent } from './container-search-reserve.component';

describe('ContainerSearchReserveComponent', () => {
  let component: ContainerSearchReserveComponent;
  let fixture: ComponentFixture<ContainerSearchReserveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContainerSearchReserveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContainerSearchReserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
