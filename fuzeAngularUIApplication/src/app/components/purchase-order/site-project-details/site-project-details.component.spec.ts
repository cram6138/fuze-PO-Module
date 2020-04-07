import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteProjectDetailsComponent } from './site-project-details.component';

describe('SiteProjectDetailsComponent', () => {
  let component: SiteProjectDetailsComponent;
  let fixture: ComponentFixture<SiteProjectDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiteProjectDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiteProjectDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
