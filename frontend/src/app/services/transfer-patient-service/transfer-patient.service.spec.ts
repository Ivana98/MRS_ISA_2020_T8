import { TestBed } from '@angular/core/testing';

import { TransferPatientService } from './transfer-patient.service';

describe('TransferPatientService', () => {
  let service: TransferPatientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransferPatientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
