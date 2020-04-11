import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoV2Component } from './demo-v2.component';

describe('DemoV2Component', () => {
  let component: DemoV2Component;
  let fixture: ComponentFixture<DemoV2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DemoV2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DemoV2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
