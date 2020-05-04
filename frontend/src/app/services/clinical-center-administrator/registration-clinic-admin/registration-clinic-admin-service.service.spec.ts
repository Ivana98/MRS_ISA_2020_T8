import { TestBed } from '@angular/core/testing';

import { RegistrationClinicAdminServiceService } from './registration-clinic-admin-service.service';

describe('RegistrationClinicAdminServiceService', () => {
  let service: RegistrationClinicAdminServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrationClinicAdminServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
