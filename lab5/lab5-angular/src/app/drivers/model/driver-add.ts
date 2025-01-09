import {FormulaTeam} from '../../formulaTeams/model/formulaTeam';

export interface DriverAdd{
  driverName: string;
  driverSurname: string;
  driverNationality: string;
  driverWDCTitles: number;
  formulaTeamID: string;
}
