import { TestBed } from '@angular/core/testing';

import { SomeLogicService } from './some-logic.service';

describe('SomeLogicService', () => {
  let service: SomeLogicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SomeLogicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
