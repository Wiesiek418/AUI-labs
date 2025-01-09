import { Component, OnInit } from '@angular/core';
import { DriverService } from "../../service/driver.service";
import { ActivatedRoute, Router } from "@angular/router";
import { DriverDetail } from "../../model/driver-detail";
import {NgIf} from '@angular/common';
import {FormulaTeamService} from '../../../formulaTeams/service/formulaTeam.service';

/**
 * Preview of single character.
 */
@Component({
  selector: 'app-driver-view',
  templateUrl: './driver-view.component.html',
  providers: [DriverService,FormulaTeamService],
  standalone: true,
  imports: [
    NgIf
  ],
  styleUrls: ['./driver-view.component.css']
})
export class DriverViewComponent implements OnInit {

  /**
   * Single character.
   */
  character: DriverDetail | undefined;

  constructor(private service: DriverService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getDriver(params['uuid'])
        .subscribe(character => this.character = character)
    });
  }

}

