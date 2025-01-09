import { Component, OnInit } from '@angular/core';
import { FormulaTeamService } from "../../service/formulaTeam.service";
import { FormulaTeams } from "../../model/formulaTeams";
import { FormulaTeam } from "../../model/formulaTeam";
import {NgForOf, NgIf} from '@angular/common';
import {RouterLink} from '@angular/router';
import {DriverService} from '../../../drivers/service/driver.service';
import {Observable} from 'rxjs';
import {Driver} from '../../../drivers/model/driver';

@Component({
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterLink
  ],
  providers: [DriverService, FormulaTeamService],
  selector: 'app-driver-list',
  templateUrl: './formulaTeam-list.component.html',
  styleUrls: ['./formulaTeam-list.component.css']
})
export class FormulaTeamListComponent implements OnInit{

  constructor(private service: FormulaTeamService) {
  }

  formulaTeams: FormulaTeams | undefined;

  ngOnInit(): void {
    this.service.getFormulaTeams().subscribe(team => this.formulaTeams = team);
  }

  onDelete(team: FormulaTeam): void {
    this.service.deleteFormulaTeam(team.formulaTeamID).subscribe(() => this.ngOnInit());
  }

}
