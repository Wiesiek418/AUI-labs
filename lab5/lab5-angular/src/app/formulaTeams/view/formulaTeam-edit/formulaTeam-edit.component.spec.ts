import {ComponentFixture, TestBed} from '@angular/core/testing';
import {FormulaTeamEditComponent} from './formulaTeam-edit.component';

describe('DriverEditComponent', () => {
  let component: FormulaTeamEditComponent;
  let fixture: ComponentFixture<FormulaTeamEditComponent>;

  beforeEach(() =>{
    TestBed.configureTestingModule({
      declarations: [FormulaTeamEditComponent]
    });
    fixture = TestBed.createComponent(FormulaTeamEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create',()=>{
    expect(component).toBeTruthy();
  });
});
