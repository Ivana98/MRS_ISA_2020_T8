import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMedicalRoomComponent } from './add-medical-room.component';

describe('AddMedicalRoomComponent', () => {
  let component: AddMedicalRoomComponent;
  let fixture: ComponentFixture<AddMedicalRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMedicalRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMedicalRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
