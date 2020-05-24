import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditClinicBasicComponent } from './edit-clinic-basic.component';

describe('EditClinicBasicComponent', () => {
  let component: EditClinicBasicComponent;
  let fixture: ComponentFixture<EditClinicBasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditClinicBasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditClinicBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
