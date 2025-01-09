import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { FormulaTeams } from "../model/formulaTeams";
import {DriverAdd} from '../../drivers/model/driver-add';
import {FormulaTeamAdd} from '../model/formulaTeam-add';
import {FormulaTeamForm} from '../model/formulaTeam-form';

/**
 * Profession management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class FormulaTeamService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all professions.
   *
   * @return list of professions
   */
  getFormulaTeams(): Observable<FormulaTeams> {
    return this.http.get<FormulaTeams>('/api/formulaTeams');
  }

  getFormulaTeam(uuid: string): Observable<any> {
    return this.http.get<any>('/api/formulaTeams/'+uuid);
  }

  deleteFormulaTeam(uuid: string): Observable<any>{
    return this.http.delete('/api/formulaTeams/'+uuid);
  }

  createFormulaTeam(request: FormulaTeamAdd): Observable<any>{
    return this.http.post('/api/formulaTeams',request);
  }

  putFormulaTeam(uuid: string, request: FormulaTeamForm): Observable<any> {
    return this.http.put<any>('/api/formulaTeams/'+uuid,request);
  }
}


