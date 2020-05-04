import { TestBed } from '@angular/core/testing';

import { ListClinicsService } from './list-clinics.service';

describe('ListClinicsService', () => {
  let service: ListClinicsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListClinicsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
