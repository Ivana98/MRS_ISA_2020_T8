import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayClinicsComponent } from './display-clinics.component';

describe('DisplayClinicsComponent', () => {
  let component: DisplayClinicsComponent;
  let fixture: ComponentFixture<DisplayClinicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayClinicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayClinicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
