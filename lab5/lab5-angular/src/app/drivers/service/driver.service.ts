import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Drivers } from "../model/drivers";
import { DriverDetail } from "../model/driver-detail";
import { DriverForm } from "../model/driver-form";
import {DriverAdd} from '../model/driver-add';

@Injectable()
export class DriverService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all characters.
   *
   * @return list of characters
   */
  getDrivers(): Observable<Drivers> {
    console.log(this.http.get<Drivers>('/api/drivers'));
    return this.http.get<Drivers>('/api/drivers');
  }

  /**
   * Fetches single characters.
   *
   * @param uuid character's id
   * @return single characters
   */
  getDriver(uuid: string): Observable<DriverDetail> {
    return this.http.get<DriverDetail>('/api/drivers/' + uuid);
  }

  /**
   * Removes single character.
   *
   * @param uuid character's id
   */
  deleteDriver(uuid: string): Observable<any> {
    return this.http.delete('/api/drivers/' + uuid);
  }

  /**
   * Updates single character.
   *
   * @param uuid character's id
   * @param request request body
   */
  putDriver(uuid: string, request: DriverForm): Observable<any> {
    return this.http.put('/api/drivers/' + uuid, request);
  }

  createDriver(request: DriverAdd): Observable<any>{
    return this.http.post('/api/drivers',request);
  }

}

