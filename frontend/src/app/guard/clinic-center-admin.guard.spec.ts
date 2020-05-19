import { TestBed } from '@angular/core/testing';

import { ClinicCenterAdminGuard } from './clinic-center-admin.guard';

describe('ClinicCenterAdminGuard', () => {
  let guard: ClinicCenterAdminGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ClinicCenterAdminGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
