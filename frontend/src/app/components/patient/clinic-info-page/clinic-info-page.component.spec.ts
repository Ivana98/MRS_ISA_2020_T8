import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClinicInfoPageComponent } from './clinic-info-page.component';

describe('ClinicInfoPageComponent', () => {
  let component: ClinicInfoPageComponent;
  let fixture: ComponentFixture<ClinicInfoPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClinicInfoPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClinicInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
