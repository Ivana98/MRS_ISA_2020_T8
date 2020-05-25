import { TestBed } from '@angular/core/testing';

import { ClinicAdminGuard } from './clinic-admin.guard';

describe('ClinicAdminGuard', () => {
  let guard: ClinicAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ClinicAdminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
