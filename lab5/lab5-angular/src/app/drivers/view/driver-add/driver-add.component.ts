import { Component, OnInit } from '@angular/core';
import { DriverService } from '../../service/driver.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DriverAdd } from '../../model/driver-add';
import { FormulaTeamService } from "../../../formulaTeams/service/formulaTeam.service";
import { FormulaTeams } from "../../../formulaTeams/model/formulaTeams";
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-driver-add',
  templateUrl: './driver-add.component.html',
  providers: [DriverService,FormulaTeamService],
  standalone: true,
  imports: [
    NgIf,
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./driver-add.component.css']
})
export class DriverAddComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  driver: DriverAdd = {driverName: "",driverSurname: "",driverNationality: "",driverWDCTitles: 0,formulaTeamID: ""};

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
    });

  }

  onSubmit(): void {
    this.driverService.createDriver(this.driver!)
      .subscribe(() => this.router.navigate(['/drivers']));
  }

}
