import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilterClinicsComponent } from './filter-clinics.component';

describe('FilterClinicsComponent', () => {
  let component: FilterClinicsComponent;
  let fixture: ComponentFixture<FilterClinicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilterClinicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterClinicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
