import {TestBed} from '@angular/core/testing';
import {FormulaTeamService} from './formulaTeam.service';

describe('FormulaTeamService', () => {
  let service: FormulaTeamService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FormulaTeamService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
})
