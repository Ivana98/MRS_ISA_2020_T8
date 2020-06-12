import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartExaminationComponent } from './start-examination.component';

describe('StartExaminationComponent', () => {
  let component: StartExaminationComponent;
  let fixture: ComponentFixture<StartExaminationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartExaminationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartExaminationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
