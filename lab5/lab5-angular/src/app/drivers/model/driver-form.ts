import {FormulaTeam} from '../../formulaTeams/model/formulaTeam';

export interface DriverForm{
  driverName: string;
  driverSurname: string;
  driverNationality: string;
  driverWDCTitles: number;
  formulaTeamID: string;
}
