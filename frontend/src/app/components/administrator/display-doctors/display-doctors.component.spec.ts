import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayDoctorsComponent } from './display-doctors.component';

describe('DisplayDoctorsComponent', () => {
  let component: DisplayDoctorsComponent;
  let fixture: ComponentFixture<DisplayDoctorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayDoctorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayDoctorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
