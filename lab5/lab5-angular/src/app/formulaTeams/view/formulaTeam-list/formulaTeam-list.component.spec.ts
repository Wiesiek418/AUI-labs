import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaTeamListComponent} from './formulaTeam-list.component';
import {FormulaTeamViewComponent} from '../formulaTeam-view/formulaTeam-view.component';

describe('FormulaTeamListComponent', () => {
  let component: FormulaTeamListComponent;
  let fixture: ComponentFixture<FormulaTeamListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormulaTeamListComponent]
    });
    fixture = TestBed.createComponent(FormulaTeamListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
