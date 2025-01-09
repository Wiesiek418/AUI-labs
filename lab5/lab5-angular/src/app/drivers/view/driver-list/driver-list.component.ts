import { Component, OnInit } from '@angular/core';
import { DriverService } from "../../service/driver.service";
import { Drivers } from "../../model/drivers";
import { Driver } from "../../model/driver";
import {RouterLink} from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';
import {NavComponent} from '../../../component/nav/nav.component';
import {MainComponent} from '../../../component/main/main.component';
import {FormulaTeamService} from '../../../formulaTeams/service/formulaTeam.service';

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  standalone: true,
  providers: [DriverService,FormulaTeamService],
  imports: [
    NgIf,
    RouterLink,
    NgForOf
  ],
  styleUrls: ['./driver-list.component.css']
})
export class DriverListComponent implements OnInit{

  /**
   * @param service characters service
   */
  constructor(private service: DriverService) {
  }

  /**
   * Available characters.
   */
  characters: Drivers | undefined;

  ngOnInit(): void {
    this.service.getDrivers().subscribe(characters => this.characters = characters);
  }


  onDelete(character: Driver): void {
    this.service.deleteDriver(character.driverID).subscribe(() => this.ngOnInit());
  }

}

