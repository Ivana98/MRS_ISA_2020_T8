import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayMedicalRoomsComponent } from './display-medical-rooms.component';

describe('DisplayMedicalRoomsComponent', () => {
  let component: DisplayMedicalRoomsComponent;
  let fixture: ComponentFixture<DisplayMedicalRoomsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayMedicalRoomsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayMedicalRoomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
