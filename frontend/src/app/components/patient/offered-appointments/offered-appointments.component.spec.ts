import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferedAppointmentsComponent } from './offered-appointments.component';

describe('OfferedAppointmentsComponent', () => {
  let component: OfferedAppointmentsComponent;
  let fixture: ComponentFixture<OfferedAppointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OfferedAppointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferedAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
