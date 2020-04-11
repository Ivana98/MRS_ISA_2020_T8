import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoV3Component } from './demo-v3.component';

describe('DemoV3Component', () => {
  let component: DemoV3Component;
  let fixture: ComponentFixture<DemoV3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoV3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoV3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
