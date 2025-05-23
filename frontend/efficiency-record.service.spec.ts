import { TestBed } from '@angular/core/testing';

import { EfficiencyRecordService } from './efficiency-record.service';

describe('EfficiencyRecordService', () => {
  let service: EfficiencyRecordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EfficiencyRecordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
