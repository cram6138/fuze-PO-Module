import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PoRequestDetailsComponent } from './po-request-details.component';

describe('PoRequestDetailsComponent', () => {
  let component: PoRequestDetailsComponent;
  let fixture: ComponentFixture<PoRequestDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PoRequestDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PoRequestDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
