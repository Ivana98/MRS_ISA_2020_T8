import { TestBed } from '@angular/core/testing';

import { HttpDemo2Service } from './http-demo2.service';

describe('HttpDemo2Service', () => {
  let service: HttpDemo2Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpDemo2Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
