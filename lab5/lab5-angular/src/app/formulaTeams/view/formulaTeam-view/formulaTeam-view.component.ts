import {Component, OnInit} from '@angular/core';
import {FormulaTeamService} from '../../service/formulaTeam.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormulaTeamDetail} from '../../model/formulaTeam-detail';
import {NgIf} from '@angular/common';
import {DriverService} from '../../../drivers/service/driver.service';

@Component({
  standalone: true,
  imports: [
    NgIf
  ],
  providers: [DriverService, FormulaTeamService],
  selector: 'app-driver-view',
  templateUrl: './formulaTeam-view.component.html',
  styleUrls: ['./formulaTeam-view.component.css']
})
export class FormulaTeamViewComponent implements OnInit{
  f1Team: FormulaTeamDetail | undefined;

  constructor(private service: FormulaTeamService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getFormulaTeam(params['uuid']).subscribe(team=>this.f1Team=team);
    });
  }

}
