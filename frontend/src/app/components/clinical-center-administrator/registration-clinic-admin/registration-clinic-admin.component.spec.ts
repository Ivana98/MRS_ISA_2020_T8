import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationClinicAdminComponent } from './registration-clinic-admin.component';

describe('RegistrationClinicAdminComponent', () => {
  let component: RegistrationClinicAdminComponent;
  let fixture: ComponentFixture<RegistrationClinicAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationClinicAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationClinicAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
