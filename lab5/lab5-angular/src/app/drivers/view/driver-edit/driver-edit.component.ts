import { Component, OnInit } from '@angular/core';
import { DriverService } from '../../service/driver.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DriverForm } from '../../model/driver-form';
import { FormulaTeamService } from "../../../formulaTeams/service/formulaTeam.service";
import { FormulaTeams } from "../../../formulaTeams/model/formulaTeams";
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-driver-edit',
  templateUrl: './driver-edit.component.html',
  providers: [DriverService,FormulaTeamService],
  standalone: true,
  imports: [
    NgIf,
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./driver-edit.component.css']
})
export class DriverEditComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  driver: DriverForm | undefined;

  /**
   * Single character.
   */
  original: DriverForm | undefined;

  /**
   * Available professions.
   */
  formulaTeams: FormulaTeams | undefined;


  constructor(
    private driverService: DriverService,
    private formulaTeamService: FormulaTeamService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.formulaTeamService.getFormulaTeams()
        .subscribe(professions => this.formulaTeams = professions);

      this.driverService.getDriver(params['uuid'])
        .subscribe(character => {
          console.log(character);
          this.uuid = params['uuid'];
          this.driver = {
            driverName: character.driverName,
            driverSurname: character.driverSurname,
            driverNationality: character.driverNationality,
            driverWDCTitles: character.driverWDCTitles,
            formulaTeamID: character.formulaTeam.formulaTeamID
          }
          this.original = {...this.driver};

        });
    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.driverService.putDriver(this.uuid!, this.driver!)
      .subscribe(() => this.router.navigate(['/drivers']));
  }

}
