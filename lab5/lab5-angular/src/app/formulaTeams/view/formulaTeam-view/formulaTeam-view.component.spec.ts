import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaTeamViewComponent } from './formulaTeam-view.component';

describe('FormulaTeamViewComponent', () => {
  let component: FormulaTeamViewComponent;
  let fixture: ComponentFixture<FormulaTeamViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormulaTeamViewComponent]
    });
    fixture = TestBed.createComponent(FormulaTeamViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
