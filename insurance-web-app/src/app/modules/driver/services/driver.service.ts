import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Driver } from '../models/driver';
import { Observable } from 'rxjs';

@Injectable()
export class DriverService {
  baseUrl: string = 'http://localhost:8080';
  driversParam: string = '/drivers';
  calculateParam: string = '/calculate';

  constructor(private http: HttpClient) {}

  public findAll(): Observable<Driver[]> {
    return this.http.get<Driver[]>(this.baseUrl + this.driversParam);
  }

  public calculateInsurance(driver: Driver) {
    return this.http.post<Driver>(this.baseUrl + this.calculateParam, driver);
  }
}
