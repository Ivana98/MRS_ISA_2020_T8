import { TestBed } from '@angular/core/testing';

import { MedicalRoomService } from './medical-room.service';

describe('MedicalRoomService', () => {
  let service: MedicalRoomService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicalRoomService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
