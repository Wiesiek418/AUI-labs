import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormulaTeamService } from "../../../formulaTeams/service/formulaTeam.service";
import { FormulaTeams } from "../../../formulaTeams/model/formulaTeams";
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';
import {FormulaTeam} from '../../model/formulaTeam';
import {FormulaTeamForm} from '../../model/formulaTeam-form';

@Component({
  selector: 'app-formulaTeam-edit',
  templateUrl: './formulaTeam-edit.component.html',
  providers: [FormulaTeamService],
  standalone: true,
  imports: [
    NgIf,
    FormsModule
  ],
  styleUrls: ['./formulateam-edit.component.css']
})
export class FormulaTeamEditComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Available professions.
   */
  formulaTeam: FormulaTeamForm | undefined;

  original: FormulaTeamForm | undefined;


  constructor(
    private formulaTeamService: FormulaTeamService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.formulaTeamService.getFormulaTeam(params['uuid'])
        .subscribe(team => {
          this.uuid = params['uuid'];
          this.formulaTeam = {
            formulaTeamName: team.formulaTeamName,
            formulaTeamNationality: team.formulaTeamNationality,
            formulaTeamWCCTitles: team.formulaTeamWCCTitles,
            formulaTeamYearFounded: team.formulaTeamYearFounded
          }
          this.original = {...this.formulaTeam};

        });
    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.formulaTeamService.putFormulaTeam(this.uuid!, this.formulaTeam!)
      .subscribe(() => this.router.navigate(['/formulaTeams']));
  }

}
