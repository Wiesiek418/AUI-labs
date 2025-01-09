import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DriverListComponent} from './drivers/view/driver-list/driver-list.component';
import {DriverViewComponent} from './drivers/view/driver-view/driver-view.component';
import {DriverEditComponent} from './drivers/view/driver-edit/driver-edit.component';
import {FormulaTeamListComponent} from './formulaTeams/view/formulaTeam-list/formulaTeam-list.component';
import {FormulaTeamViewComponent} from './formulaTeams/view/formulaTeam-view/formulaTeam-view.component';
import {DriverAddComponent} from './drivers/view/driver-add/driver-add.component';
import {FormulaTeamAddComponent} from './formulaTeams/view/formulaTeam-add/formulaTeam-add.component';
import {FormulaTeamEditComponent} from './formulaTeams/view/formulaTeam-edit/formulaTeam-edit.component';


/**
 * All available routes.
 */
export const routes: Routes = [
  {
    component: DriverListComponent,
    path: "drivers"
  }
  ,
  {
    component: DriverAddComponent,
    path: "drivers/create"
  }
  ,
  {
    component: DriverViewComponent,
    path: "drivers/:uuid"
  }
  ,
  {
    component: DriverEditComponent,
    path: "drivers/:uuid/edit"
  }
  ,
  {
    component: FormulaTeamListComponent,
    path: "formulaTeams"
  }
  ,
  {
    component: FormulaTeamAddComponent,
    path: "formulaTeams/create"
  }
  ,
  {
    component: FormulaTeamViewComponent,
    path: "formulaTeams/:uuid"
  }
  ,
  {
    component: FormulaTeamEditComponent,
    path: "formulaTeams/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}

