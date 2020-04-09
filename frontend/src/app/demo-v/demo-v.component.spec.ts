import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoVComponent } from './demo-v.component';

describe('DemoVComponent', () => {
  let component: DemoVComponent;
  let fixture: ComponentFixture<DemoVComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoVComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
