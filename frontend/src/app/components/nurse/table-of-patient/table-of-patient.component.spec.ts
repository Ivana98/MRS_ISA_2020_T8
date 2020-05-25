import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableOfPatientComponent } from './table-of-patient.component';

describe('TableOfPatientComponent', () => {
  let component: TableOfPatientComponent;
  let fixture: ComponentFixture<TableOfPatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableOfPatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableOfPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
