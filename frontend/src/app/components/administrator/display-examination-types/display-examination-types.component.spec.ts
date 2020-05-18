import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayExaminationTypesComponent } from './display-examination-types.component';

describe('DisplayExaminationTypesComponent', () => {
  let component: DisplayExaminationTypesComponent;
  let fixture: ComponentFixture<DisplayExaminationTypesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayExaminationTypesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayExaminationTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
