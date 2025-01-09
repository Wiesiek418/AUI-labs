import {FormulaTeam} from '../../formulaTeams/model/formulaTeam';

export interface DriverDetail{
  driverID: string;
  driverName: string;
  driverSurname: string;
  driverNationality: string;
  driverWDCTitles: number;
  formulaTeam: FormulaTeam;
}
