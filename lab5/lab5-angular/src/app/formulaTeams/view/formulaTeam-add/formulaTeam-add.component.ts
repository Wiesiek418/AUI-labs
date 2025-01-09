import { Component, OnInit } from '@angular/core';
import { FormulaTeamService } from '../../service/formulaTeam.service';
import { ActivatedRoute, Router } from '@angular/router';
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';
import {FormulaTeamAdd} from '../../model/formulaTeam-add';

@Component({
  selector: 'app-formulaTeam-add',
  templateUrl: './formulaTeam-add.component.html',
  providers: [FormulaTeamService],
  standalone: true,
  imports: [
    NgIf,
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./formulaTeam-add.component.css']
})
export class FormulaTeamAddComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  team: FormulaTeamAdd = {formulaTeamID: "", formulaTeamName: "", formulaTeamNationality: "", formulaTeamYearFounded: 0, formulaTeamWCCTitles: 0};



  constructor(
    private formulaTeamService: FormulaTeamService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.formulaTeamService.createFormulaTeam(this.team!)
      .subscribe(() => this.router.navigate(['/formulaTeams']));
  }

}
