import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayExaminationRequestsComponent } from './display-examination-requests.component';

describe('DisplayExaminationRequestsComponent', () => {
  let component: DisplayExaminationRequestsComponent;
  let fixture: ComponentFixture<DisplayExaminationRequestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayExaminationRequestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayExaminationRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
