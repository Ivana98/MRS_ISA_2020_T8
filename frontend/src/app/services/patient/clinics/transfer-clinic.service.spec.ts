import { TestBed } from '@angular/core/testing';

import { TransferClinicService } from './transfer-clinic.service';

describe('TransferClinicService', () => {
  let service: TransferClinicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransferClinicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
